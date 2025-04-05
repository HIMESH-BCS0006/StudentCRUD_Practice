package com.selfPrctz.StudentManagementSystem.dto.queryInterface;

import com.selfPrctz.StudentManagementSystem.entity.Course;
import com.selfPrctz.StudentManagementSystem.entity.Student;

import java.util.Date;

public interface PaymentAndEnrollmentInterface {

    double getAmount();
    Date getDate();
    Student getStudent();
    Course getCourse();
}





