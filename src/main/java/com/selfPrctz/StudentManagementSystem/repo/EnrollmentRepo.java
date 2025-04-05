package com.selfPrctz.StudentManagementSystem.repo;


import com.selfPrctz.StudentManagementSystem.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {

}
