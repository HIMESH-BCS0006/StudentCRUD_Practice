package com.selfPrctz.StudentManagementSystem.repo;

import com.selfPrctz.StudentManagementSystem.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CourseRepo extends JpaRepository<Course, Long> {


    Page<Course> findAll(Pageable pageable);

}
