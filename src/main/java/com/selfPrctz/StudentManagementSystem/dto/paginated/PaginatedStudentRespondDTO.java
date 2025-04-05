package com.selfPrctz.StudentManagementSystem.dto.paginated;


import com.selfPrctz.StudentManagementSystem.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedStudentRespondDTO {

    List<StudentDTO> list;
    private long dataCount;
}
