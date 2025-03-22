package com.selfPrctz.StudentManagementSystem.util.mappers;

import com.selfPrctz.StudentManagementSystem.dto.StudentDTO;
import com.selfPrctz.StudentManagementSystem.entity.Student;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student dtoToentity(StudentDTO studentDTO);
    StudentDTO entityTODTO(Student student);
    List<StudentDTO> entityListTODTOList(List<Student> studentList);
    List<StudentDTO> ListDTOToPage(Page<Student> studentPage);



}

// Thing to map-----> methodName(Thing We have );
