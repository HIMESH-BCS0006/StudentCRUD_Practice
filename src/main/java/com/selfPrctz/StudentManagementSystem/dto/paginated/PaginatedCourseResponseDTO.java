package com.selfPrctz.StudentManagementSystem.dto.paginated;


import com.selfPrctz.StudentManagementSystem.dto.CourseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedCourseResponseDTO {

    List<CourseDTO> courseDTOList;
    private long dataCount;

}
