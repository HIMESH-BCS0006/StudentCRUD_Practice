package com.selfPrctz.StudentManagementSystem.service.impl;


import com.selfPrctz.StudentManagementSystem.dto.StudentDTO;
import com.selfPrctz.StudentManagementSystem.dto.paginated.PaginatedStudentRespondDTO;
import com.selfPrctz.StudentManagementSystem.dto.request.StudentUpdateDTO;
import com.selfPrctz.StudentManagementSystem.entity.Student;
import com.selfPrctz.StudentManagementSystem.exception.NotFoundException;
import com.selfPrctz.StudentManagementSystem.repo.StudentRepo;
import com.selfPrctz.StudentManagementSystem.service.StudentService;
import com.selfPrctz.StudentManagementSystem.util.mappers.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public String saveStudent(StudentDTO studentDTO) {

        Student student = studentMapper.dtoToentity(studentDTO);
        studentRepo.save(student);
        return studentDTO.getFirstName() + "saved successfully";
    }

    @Override
    public StudentDTO getStudentById(long studentId) {
        if (studentRepo.existsById(studentId)) {
            Student student = studentRepo.getReferenceById(studentId);
            StudentDTO studentDTO = studentMapper.entityTODTO(student);

            return studentDTO;
        } else {
            throw new NotFoundException("Student not found");
        }


    }

    @Override
    public String updateStudent(StudentUpdateDTO studentUpdateDTO) {

        if(studentRepo.existsById(studentUpdateDTO.getId())){
            Student student = studentRepo.getReferenceById(studentUpdateDTO.getId());

            student.setId(studentUpdateDTO.getId());
            student.setContactNumber(studentUpdateDTO.getContactNumber());
            student.setDateOfBirth(studentUpdateDTO.getDateOfBirth());
            student.setAddress(studentUpdateDTO.getAddress());
            studentRepo.save(student);

            return "Student updated successfully";



        }else{
            throw new NotFoundException("Student not found");
        }


    }

    @Override
    public PaginatedStudentRespondDTO getAllStudentWithPagination(int page, int size) {
        Page<Student> student = studentRepo.findAll(PageRequest.of(page, size));
        if(student.getTotalElements()>0){
            PaginatedStudentRespondDTO studentRespondDTO = new PaginatedStudentRespondDTO(
                    studentMapper.ListDTOToPage(student),studentRepo.count()
            );

            return studentRespondDTO;

        }else{
            throw new NotFoundException("Student not found");
        }

    }

    @Override
    public String deleteStudent(long id) {
        if(studentRepo.existsById(id)){
            studentRepo.deleteById(id);
            return "Student deleted successfully";

        }else{
            throw new NotFoundException("Student not found");
        }

    }

    @Override
    public List<StudentDTO> getStudentByState(boolean activeState) {
        List<Student> studentList = studentRepo.findAllByActiveState(activeState);

        if(studentList.size()>0){
            List<StudentDTO> studentDTOList =  studentMapper.entityListTODTOList(studentList);
            return studentDTOList;

        }else{
            throw new NotFoundException("Student not found");
        }

    }

    @Override
    public List<StudentDTO> getStudentByGender(String gender) {
        List<Student> studentList = studentRepo.findAllByGenderIs(gender);
        if(studentList.size()>0){
            List<StudentDTO> studentDTOList =  studentMapper.entityListTODTOList(studentList);
        }else{
            throw new NotFoundException("Student not found");
        }
        return List.of();
    }

    @Override
    public PaginatedStudentRespondDTO getAllStudentwithActiveStateAndPagination(boolean activeState, int page, int size) {

        Page<Student> students = studentRepo.findAllByActiveState(activeState,PageRequest.of(page,size));

        if(students.getTotalElements()>0){
            PaginatedStudentRespondDTO studentRespondDTO = new PaginatedStudentRespondDTO(
                    studentMapper.ListDTOToPage(students),studentRepo.count()
            );

            return studentRespondDTO;
        }else{
            throw new NotFoundException("Student not found");
        }

    }
}
