package com.selfPrctz.StudentManagementSystem.service.impl;


import com.selfPrctz.StudentManagementSystem.dto.StudentDTO;
import com.selfPrctz.StudentManagementSystem.dto.request.StudentUpdateDTO;
import com.selfPrctz.StudentManagementSystem.entity.Student;
import com.selfPrctz.StudentManagementSystem.repo.StudentRepo;
import com.selfPrctz.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String saveStudent(StudentDTO studentDTO) {
        Student student = new Student(
                studentDTO.getId(),
                studentDTO.getFirstName(),
                studentDTO.getLastName(),
                studentDTO.getNic(),
                studentDTO.getContactNumber(),
                studentDTO.getDateOfBirth(),
                studentDTO.getAddress(),
                studentDTO.getGender(),
                studentDTO.isActiveState()

        );

        studentRepo.save(student);

        return student.getFirstName() + " saved successfully";
    }

    @Override
    public StudentDTO getStudentById(long studentId) {
        if (studentRepo.existsById(studentId)) {
            Student student = studentRepo.getReferenceById(studentId);
            StudentDTO studentDTO = new StudentDTO(
                    student.getId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getNic(),
                    student.getContactNumber(),
                    student.getDateOfBirth(),
                    student.getAddress(),
                    student.getGender(),
                    student.isActiveState()
            );
            return studentDTO;


        }else{
            throw new RuntimeException("Student with id " + studentId + " not found");
        }
    }

    @Override
    public String updateStudent(StudentUpdateDTO studentUpdateDTO) {
        if (studentRepo.existsById(studentUpdateDTO.getId())) {
            Student student = studentRepo.getReferenceById(studentUpdateDTO.getId());
            student.setContactNumber(studentUpdateDTO.getContactNumber());
            student.setDateOfBirth(studentUpdateDTO.getDateOfBirth());
            student.setAddress(studentUpdateDTO.getAddress());

            studentRepo.save(student);
            return student.getFirstName() + " updated successfully";
        }else{
            throw new RuntimeException("Student with id " + studentUpdateDTO.getId() + " not found");
        }

    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> allStudents = studentRepo.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for(Student student : allStudents){
            StudentDTO studentDTO = new StudentDTO(
                    student.getId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getNic(),
                    student.getContactNumber(),
                    student.getDateOfBirth(),
                    student.getAddress(),
                    student.getGender(),
                    student.isActiveState()
            );

            studentDTOList.add(studentDTO);

        }



        return studentDTOList;
    }

    @Override
    public String deleteStudent(long id) {
        if(studentRepo.existsById(id)){
            studentRepo.deleteById(id);
            return "Student with id " + id + " deleted successfully";

        }else{
            throw new RuntimeException("Student with id " + id + " not found");
        }



    }

    @Override
    public List<StudentDTO> getStudentByState(boolean activeState) {
        
        List<Student> studentList = studentRepo.findAllByActiveStateEquals(activeState);

        List<StudentDTO> studentDTOList = new ArrayList<>();

        for(Student student : studentList){
            StudentDTO studentDTO = new StudentDTO(
                    student.getId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getNic(),
                    student.getContactNumber(),
                    student.getDateOfBirth(),
                    student.getAddress(),
                    student.getGender(),
                    student.isActiveState()
            );

            studentDTOList.add(studentDTO);

        }
        return studentDTOList;

    }
}
