package com.selfPrctz.StudentManagementSystem.dto.respond;


import com.selfPrctz.StudentManagementSystem.entity.Course;
import com.selfPrctz.StudentManagementSystem.entity.Student;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsePaymentDetailsDTO {

    //payment
    private double amount;
    private Date date;

    //enrollment

    Student student;
    Course course;


//    public ResponsePaymentDetailsDTO(double amount, Date date, Student student, Course course) {
//        this.amount = amount;
//        this.date = date;
//        this.student = student;
//        this.course = course;
//    }
}
