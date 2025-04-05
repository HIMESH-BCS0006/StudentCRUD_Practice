package com.selfPrctz.StudentManagementSystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "enrollment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Enrollment {

    @Id
    @Column(name = "enrollment_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long enrollmentId;

    @Column(name = "enrollment_dat", length = 45)
    private Date enrollmentDate;


    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    @ManyToOne
    @JoinColumn(name="payment_id", nullable=false)
    private Payment payments;



}
