package com.selfPrctz.StudentManagementSystem.repo;


import com.selfPrctz.StudentManagementSystem.dto.queryInterface.PaymentAndEnrollmentInterface;
import com.selfPrctz.StudentManagementSystem.dto.respond.ResponsePaymentDetailsDTO;
import com.selfPrctz.StudentManagementSystem.entity.Course;
import com.selfPrctz.StudentManagementSystem.entity.Payment;
import com.selfPrctz.StudentManagementSystem.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface PaymentRepo extends JpaRepository<Payment, Integer> {


    @Query(value = "SELECT p.amount AS amount, p.payment_date AS date, e.student_id AS student, e.course_id AS course " +
            "FROM payment p " +
            "JOIN enrollment e ON p.payment_id = e.payment_id", nativeQuery = true)
    Page<PaymentAndEnrollmentInterface> getAllPaymentDetails(Pageable pageable);
}


