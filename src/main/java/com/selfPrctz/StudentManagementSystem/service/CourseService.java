package com.selfPrctz.StudentManagementSystem.service;

import com.selfPrctz.StudentManagementSystem.dto.CourseDTO;
import com.selfPrctz.StudentManagementSystem.dto.StudentDTO;
import com.selfPrctz.StudentManagementSystem.dto.paginated.PaginatedCourseResponseDTO;
import com.selfPrctz.StudentManagementSystem.dto.paginated.PaginatedStudentRespondDTO;

import java.util.List;

public interface CourseService {


    String saveCourse(CourseDTO courseDTO);

    PaginatedCourseResponseDTO getAllCourses(int page, int size);

    String deleteCourse(long courseId);
}
