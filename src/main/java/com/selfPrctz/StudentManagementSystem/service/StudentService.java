package com.selfPrctz.StudentManagementSystem.service;


import com.selfPrctz.StudentManagementSystem.dto.StudentDTO;
import com.selfPrctz.StudentManagementSystem.dto.paginated.PaginatedStudentRespondDTO;
import com.selfPrctz.StudentManagementSystem.dto.request.StudentUpdateDTO;

import java.util.List;

public interface StudentService {


    String saveStudent(StudentDTO studentDTO);

    StudentDTO getStudentById(long studentId);

    String updateStudent(StudentUpdateDTO studentUpdateDTO);

    PaginatedStudentRespondDTO getAllStudentWithPagination(int page, int size);

    String deleteStudent(long id);

    List<StudentDTO> getStudentByState(boolean activeState);

    List<StudentDTO> getStudentByGender(String gender);

    PaginatedStudentRespondDTO getAllStudentwithActiveStateAndPagination(boolean activeState, int page, int size);
}
