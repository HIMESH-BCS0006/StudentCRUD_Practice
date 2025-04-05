package com.selfPrctz.StudentManagementSystem.dto.request;

import com.selfPrctz.StudentManagementSystem.entity.Course;
import com.selfPrctz.StudentManagementSystem.entity.Payment;
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
public class RequestEnrollmentSaveDTO {

    private Date enrollmentDate;
    private long student;
   private long course;
   // private int payments;
}
