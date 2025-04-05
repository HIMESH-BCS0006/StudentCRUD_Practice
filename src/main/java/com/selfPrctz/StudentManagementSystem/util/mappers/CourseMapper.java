package com.selfPrctz.StudentManagementSystem.util.mappers;


import com.selfPrctz.StudentManagementSystem.dto.CourseDTO;
import com.selfPrctz.StudentManagementSystem.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course dtoToEntity(CourseDTO courseDTO);
    CourseDTO entityToDto(Course course);

    List<CourseDTO> entityListToDtoList(List<Course> courseList);



}
