package com.selfPrctz.StudentManagementSystem.repo;


import com.selfPrctz.StudentManagementSystem.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface StudentRepo extends JpaRepository<Student,Long> {

    //List<Student> findAllByActiveStateEquals(boolean activeState);

    List<Student> findAllByGenderIs(String gender);

    List<Student> findAllByActiveState(boolean activeState);

    Page<Student> findAllByActiveState(boolean activeState, Pageable pageable);
}
