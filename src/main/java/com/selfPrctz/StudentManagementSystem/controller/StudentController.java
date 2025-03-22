package com.selfPrctz.StudentManagementSystem.controller;


import com.selfPrctz.StudentManagementSystem.dto.StudentDTO;
import com.selfPrctz.StudentManagementSystem.dto.paginated.PaginatedStudentRespondDTO;
import com.selfPrctz.StudentManagementSystem.dto.request.StudentUpdateDTO;
import com.selfPrctz.StudentManagementSystem.service.StudentService;
import com.selfPrctz.StudentManagementSystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


//    @PostMapping(
//            path = "/save-student"
//    )
//    public String saveStudent( @RequestBody StudentDTO studentDTO){
//
//        String message = studentService.saveStudent(studentDTO);
//
//        return message;
//    }
@PostMapping(
        path = "/save-student"
)
public ResponseEntity<StandardResponse> saveStudent(@RequestBody StudentDTO studentDTO){

    String message = studentService.saveStudent(studentDTO);

    return new ResponseEntity<StandardResponse>(
            new StandardResponse(201,"successfull",message), HttpStatus.CREATED
    );
}


//    @GetMapping(
//            path = "/get-student-by-id/{id}"
//    )
//    public StudentDTO getStudentById(@PathVariable(value = "id" )long student_id){
//        StudentDTO studentDTO =  studentService.getStudentById(student_id);
//
//        return studentDTO;
//
//}

    @GetMapping(
            path = "/get-student-by-id/{id}"
    )
    public ResponseEntity<StandardResponse> getStudentById(@PathVariable(value = "id" )long student_id){
        StudentDTO studentDTO =  studentService.getStudentById(student_id);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successfull",studentDTO), HttpStatus.OK
        );

    }

//    @PutMapping(
//            path = "/update-student"
//    )
//    public String updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO){
//        String message = studentService.updateStudent(studentUpdateDTO);
//
//        return message;
//    }

    @PutMapping(
            path = "/update-student"
    )
    public ResponseEntity<StandardResponse> updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO){
        String message = studentService.updateStudent(studentUpdateDTO);


        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successfull",message), HttpStatus.OK
        );
    }



    @GetMapping(
            path = "/get-all-students",
            params = {"page","size"}
    )
    public ResponseEntity<StandardResponse> getAllStudentsWithPagination(@RequestParam(value = "page") int page,
                                                         @RequestParam(value = "size") int size){
        //List<StudentDTO> allStudent = studentService.getAllStudents();

        PaginatedStudentRespondDTO studentList = studentService.getAllStudentWithPagination(page,size);

        return  new ResponseEntity<>(
                new StandardResponse(200,"Successful",studentList), HttpStatus.OK
        );

    }
    @DeleteMapping(
            path = "/delete-student/{id}"
    )
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable(value = "id" )long id){
        String message = studentService.deleteStudent(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successfull",message), HttpStatus.OK
        );
    }

    @GetMapping(
            path = "get-student-by-state/{activeState}"
    )
    public ResponseEntity<StandardResponse> getStudentByState(@PathVariable(value = "activeState" )boolean activeState){
        List<StudentDTO> studentDTOList = studentService.getStudentByState(activeState);

        return  new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successful",studentDTOList), HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-student-by-gender/{gender}"
    )
    public ResponseEntity<StandardResponse> getStudentsByGender(@PathVariable String gender){

        List<StudentDTO> studentDTOList = studentService.getStudentByGender(gender);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successful",studentDTOList), HttpStatus.OK
        );

    }

    @GetMapping(
            path = "get-student-by-state-with-pagination",
            params = {"activeState","page","size"}
    )
    public ResponseEntity<StandardResponse> getStudentByStateAndPagination(@RequestParam(value = "activeState" )boolean activeState,
                                                                           @RequestParam(value = "page") int page,
                                                                           @RequestParam (value = "size") int size){
        //List<StudentDTO> studentDTOList = studentService.getStudentByState(activeState);

        PaginatedStudentRespondDTO studentDTOList = studentService.getAllStudentwithActiveStateAndPagination(activeState,page,size);

        return  new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successful",studentDTOList), HttpStatus.OK
        );
    }



}
