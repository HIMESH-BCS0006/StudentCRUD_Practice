package com.selfPrctz.StudentManagementSystem.service;

import com.selfPrctz.StudentManagementSystem.dto.paginated.PaginatedResponsePaymentDetailsDTO;
import com.selfPrctz.StudentManagementSystem.dto.request.RequestEnrollmentSaveDTO;
import com.selfPrctz.StudentManagementSystem.dto.request.RequestPaymentSaveDTO;

public interface PaymentService {
    String savePayment(RequestPaymentSaveDTO requestPaymentSaveDTO);

    PaginatedResponsePaymentDetailsDTO getPaymentDetails(int page, int size);
}
