package com.selfPrctz.StudentManagementSystem.entity;

import com.selfPrctz.StudentManagementSystem.entity.enums.CourseType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {

    @Id
    @Column(name = "course_id",length = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "course_name",length = 100,nullable = false)
    private String name;


    @Enumerated(EnumType.STRING)
    @Column(name = "course_type",length = 45,nullable = false)
    private CourseType courseType;

    @Column(name = "course_fee",length = 100,nullable = false)
    private double fee;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0")
    private boolean active;

    @OneToMany(mappedBy = "course")
    Set<Enrollment> registrations;


    public Course(String name, CourseType courseType, double fee, Object o) {
        this.name = name;
        this.courseType = courseType;
        this.fee = fee;
    }
}
