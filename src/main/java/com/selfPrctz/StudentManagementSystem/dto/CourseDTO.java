package com.selfPrctz.StudentManagementSystem.dto;

import com.selfPrctz.StudentManagementSystem.entity.enums.CourseType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO {

    private String name;
    private CourseType courseType;
    private double fee;
    private boolean active;


}
