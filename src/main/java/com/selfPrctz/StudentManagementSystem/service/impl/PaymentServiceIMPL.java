package com.selfPrctz.StudentManagementSystem.service.impl;

import com.selfPrctz.StudentManagementSystem.dto.paginated.PaginatedResponsePaymentDetailsDTO;
import com.selfPrctz.StudentManagementSystem.dto.queryInterface.PaymentAndEnrollmentInterface;
import com.selfPrctz.StudentManagementSystem.dto.request.RequestPaymentSaveDTO;
import com.selfPrctz.StudentManagementSystem.dto.respond.ResponsePaymentDetailsDTO;
import com.selfPrctz.StudentManagementSystem.entity.Enrollment;
import com.selfPrctz.StudentManagementSystem.entity.Payment;
import com.selfPrctz.StudentManagementSystem.repo.EnrollmentRepo;
import com.selfPrctz.StudentManagementSystem.repo.PaymentRepo;
import com.selfPrctz.StudentManagementSystem.service.PaymentService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PaymentServiceIMPL implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EnrollmentRepo enrollmentRepo;




    @Override
    @Transactional
    public String savePayment(RequestPaymentSaveDTO requestPaymentSaveDTO) {
        Payment payment = new Payment(
                requestPaymentSaveDTO.getAmount(),
                requestPaymentSaveDTO.getDate()

        );

        paymentRepo.save(payment);

        if(paymentRepo.existsById(payment.getPaymentId())){

            List<Enrollment> enrollmentList = modelMapper.map(requestPaymentSaveDTO.getEnrollment(),
                    new TypeToken<List<Enrollment>>(){}.getType());

            for(int i=0; i<enrollmentList.size(); i++){
                enrollmentList.get(i).setPayments(payment);



            }

            if(enrollmentList.size()>0){
                  enrollmentRepo.saveAll(enrollmentList);
            }
            return "saved";

        }

        return null;

    }

    @Override
    public PaginatedResponsePaymentDetailsDTO getPaymentDetails(int page, int size) {

        //List<ResponsePaymentDetailsDTO> responsePaymentDetailsDTOList = paymentRepo.getAllPaymentDetails(PageRequest.of(page, size));
        Page<PaymentAndEnrollmentInterface> paymentAndEnrollmentInterfaceList = paymentRepo.getAllPaymentDetails(PageRequest.of(page, size));

        List<ResponsePaymentDetailsDTO> responsePaymentDetailsDTOList = new ArrayList<>();

        for(PaymentAndEnrollmentInterface payment : paymentAndEnrollmentInterfaceList){
            ResponsePaymentDetailsDTO responsePaymentDetailsDTO = new ResponsePaymentDetailsDTO(
                    payment.getAmount(),
                    payment.getDate(),
                    payment.getStudent(),
                    payment.getCourse()
            );

            responsePaymentDetailsDTOList.add(responsePaymentDetailsDTO);


        }

        PaginatedResponsePaymentDetailsDTO responsePaymentDetailsDTO = new PaginatedResponsePaymentDetailsDTO(
                responsePaymentDetailsDTOList,
                paymentRepo.count()
        );





        return responsePaymentDetailsDTO;
    }
}
