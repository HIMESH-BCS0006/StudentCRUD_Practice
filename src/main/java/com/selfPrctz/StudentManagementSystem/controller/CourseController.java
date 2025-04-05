package com.selfPrctz.StudentManagementSystem.controller;


import com.selfPrctz.StudentManagementSystem.dto.CourseDTO;
import com.selfPrctz.StudentManagementSystem.dto.StudentDTO;
import com.selfPrctz.StudentManagementSystem.dto.paginated.PaginatedCourseResponseDTO;
import com.selfPrctz.StudentManagementSystem.dto.paginated.PaginatedStudentRespondDTO;
import com.selfPrctz.StudentManagementSystem.service.CourseService;
import com.selfPrctz.StudentManagementSystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/course")
public class CourseController {


    @Autowired
    private CourseService courseService;


    @PostMapping(
            path = "/save-course"

    )
    public ResponseEntity<StandardResponse> saveCourse(@RequestBody CourseDTO courseDTO) {

        String message = courseService.saveCourse(courseDTO);
        return new ResponseEntity<>(
                new StandardResponse(200,"Success",message ), HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/get-course",
            params = {"page","size"}

    )

    public ResponseEntity<StandardResponse> getAllCourses(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size")  int size
    ) {

        PaginatedCourseResponseDTO paginatedCourseResponseDTO = courseService.getAllCourses(page, size);


        return  new ResponseEntity<>(
                new StandardResponse(200,"Success",paginatedCourseResponseDTO), HttpStatus.OK
        );

    }

    @DeleteMapping(
            path = "/delete-course",
            params = {"courseId"}
    )
    public ResponseEntity<StandardResponse> deleteCourse(@RequestParam(value = "courseId") long courseId) {
        String message = courseService.deleteCourse(courseId);
        return new ResponseEntity<>(
                new StandardResponse(200,"Success",message), HttpStatus.OK
        );
    }








}
