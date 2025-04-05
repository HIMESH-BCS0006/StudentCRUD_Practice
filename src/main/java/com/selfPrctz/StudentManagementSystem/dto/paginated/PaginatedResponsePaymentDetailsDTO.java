package com.selfPrctz.StudentManagementSystem.dto.paginated;


import com.selfPrctz.StudentManagementSystem.dto.respond.ResponsePaymentDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponsePaymentDetailsDTO {

    List<ResponsePaymentDetailsDTO> paymentDetailsDTOList;
    private long dataCount;
}
