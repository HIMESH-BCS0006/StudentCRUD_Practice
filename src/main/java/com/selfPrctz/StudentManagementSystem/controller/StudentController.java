package com.selfPrctz.StudentManagementSystem.controller;


import com.selfPrctz.StudentManagementSystem.dto.StudentDTO;
import com.selfPrctz.StudentManagementSystem.dto.request.StudentUpdateDTO;
import com.selfPrctz.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping(
            path = "/save-student"
    )
    public String saveStudent( @RequestBody StudentDTO studentDTO){

        String message = studentService.saveStudent(studentDTO);

        return message;
    }

    @GetMapping(
            path = "/get-student-by-id/{id}"
    )
    public StudentDTO getStudentById(@PathVariable(value = "id" )long student_id){
        StudentDTO studentDTO =  studentService.getStudentById(student_id);

        return studentDTO;


    }

    @PutMapping(
            path = "/update-student"
    )
    public String updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO){
        String message = studentService.updateStudent(studentUpdateDTO);

        return message;
    }

    @GetMapping(
            path = "/get-all-students"
    )
    public List<StudentDTO> getAllStudents(){
        List<StudentDTO> allStudent = studentService.getAllStudents();

        return  allStudent;

    }
    @DeleteMapping(
            path = "/delete-student/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id" )long id){
        String message = studentService.deleteStudent(id);
        return message;
    }

    @GetMapping(
            path = "get-student-by-state/{activeState}"
    )
    public List<StudentDTO> getStudentByState(@PathVariable(value = "activeState" )boolean activeState){
        List<StudentDTO> studentDTOList = studentService.getStudentByState(activeState);

        return  studentDTOList;
    }


}
