package com.selfPrctz.StudentManagementSystem.controller;

import com.selfPrctz.StudentManagementSystem.dto.paginated.PaginatedResponsePaymentDetailsDTO;
import com.selfPrctz.StudentManagementSystem.dto.request.RequestEnrollmentSaveDTO;
import com.selfPrctz.StudentManagementSystem.dto.request.RequestPaymentSaveDTO;
import com.selfPrctz.StudentManagementSystem.service.PaymentService;
import com.selfPrctz.StudentManagementSystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;



    @PostMapping(
            path = "/save-payment"
    )
    public ResponseEntity<StandardResponse> savePayment(@RequestBody RequestPaymentSaveDTO requestPaymentSaveDTO) {

        String message = paymentService.savePayment(requestPaymentSaveDTO);

        return new ResponseEntity<>(
                new StandardResponse(200,"Success",message ), HttpStatus.CREATED
        );

    }


    @GetMapping(
            path = "/get-payment",
            params = {"page","size"}
    )
    public ResponseEntity<StandardResponse> getPaymentDetails(@RequestParam(value = "page") int page,
                                                              @RequestParam(value = "size")  int size) {

        PaginatedResponsePaymentDetailsDTO paginatedResponsePaymentDetailsDTO = paymentService.getPaymentDetails(page, size);
        return new ResponseEntity<>(
                new StandardResponse(200,"Success",paginatedResponsePaymentDetailsDTO), HttpStatus.OK
        );


    }

}

