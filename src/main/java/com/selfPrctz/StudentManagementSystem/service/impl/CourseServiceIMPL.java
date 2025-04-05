package com.selfPrctz.StudentManagementSystem.service.impl;


import com.selfPrctz.StudentManagementSystem.dto.CourseDTO;
import com.selfPrctz.StudentManagementSystem.dto.StudentDTO;
import com.selfPrctz.StudentManagementSystem.dto.paginated.PaginatedCourseResponseDTO;
import com.selfPrctz.StudentManagementSystem.dto.paginated.PaginatedStudentRespondDTO;
import com.selfPrctz.StudentManagementSystem.entity.Course;
import com.selfPrctz.StudentManagementSystem.exception.NotFoundException;
import com.selfPrctz.StudentManagementSystem.repo.CourseRepo;
import com.selfPrctz.StudentManagementSystem.service.CourseService;
import com.selfPrctz.StudentManagementSystem.util.mappers.CourseMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceIMPL implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public String saveCourse(CourseDTO courseDTO) {

        Course course = modelMapper.map(courseDTO, Course.class);


            courseRepo.save(course);
            return "Course saved successfully";



    }

    @Override
    public PaginatedCourseResponseDTO getAllCourses(int page, int size) {

        Page<Course> courses = courseRepo.findAll(PageRequest.of(page, size));
        if (courses.getTotalElements() > 0) {
            // Convert the content of Page<Course> to List<CourseDTO>
            List<CourseDTO> dtoList = modelMapper.map(
                    courses.getContent(),
                    new TypeToken<List<CourseDTO>>() {}.getType()
            );

            return new PaginatedCourseResponseDTO(dtoList, courses.getTotalElements());
        } else {
            throw new NotFoundException("No Records Found!!");
        }
//        List<Course> courseList = courseRepo.findAll();
//        List<CourseDTO> courseDTOList = modelMapper.map(courseList, new TypeToken<List<CourseDTO>>() {
//        }.getType());
//
//        return courseDTOList;
    }

    @Override
    public String deleteCourse(long courseId) {
        if (courseRepo.existsById(courseId)) {
            courseRepo.deleteById(courseId);
            return "Course Deleted Successfully";
        }else {
            throw new NotFoundException("No Course Found with this ID");
        }
    }
}
