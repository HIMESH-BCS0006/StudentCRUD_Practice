package com.selfPrctz.StudentManagementSystem.dto.request;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestPaymentSaveDTO {

    private double amount;
    private Date date;
    List<RequestEnrollmentSaveDTO> enrollment;





}
