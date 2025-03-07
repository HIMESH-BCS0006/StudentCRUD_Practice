package com.selfPrctz.StudentManagementSystem.repo;


import com.selfPrctz.StudentManagementSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface StudentRepo extends JpaRepository<Student,Long> {

    List<Student> findAllByActiveStateEquals(boolean activeState);
}
