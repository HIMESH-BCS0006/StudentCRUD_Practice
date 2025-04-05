package com.selfPrctz.StudentManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "payment")

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id", length = 45)
    private int paymentId;

    @Column(name = "amount", length = 100, nullable = false)
    private double amount;

    @Column(name = "payment_date", columnDefinition = "DATETIME")
    private Date date;

    @OneToMany(mappedBy="payments")
    private Set<Enrollment> enrollments;


    public Payment(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }
}
