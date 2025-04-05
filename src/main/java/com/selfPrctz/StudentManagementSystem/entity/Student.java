package com.selfPrctz.StudentManagementSystem.entity;


import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id",length = 20)
    private long id;

    @Column(name = "first_name",length = 255, nullable = false)
    private String firstName;


    @Column(name = "last_name",length = 255, nullable = false)
    private String lastName;

    @Column(name = "student_nic",length = 60, nullable = false)
    private String nic;

    @Type(JsonType.class)
    @Column(name = "contact_number",length = 255, columnDefinition = "json")
    private List<String> contactNumber;

    @Column(name = "dob",length = 45,nullable = false)
    private String dateOfBirth;

    @Column(name = "address",length = 255)
    private String address;

    @Column(name = "gender", length = 20)
    private String gender;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0")
    private boolean activeState;

    @OneToMany(mappedBy = "student")
    Set<Enrollment> enrollments;







    public Student() {
    }

    public Student(long id, String firstName, String lastName, String nic, List<String> contactNumber, String dateOfBirth, String address, String gender, boolean activeState) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.gender = gender;
        this.activeState = activeState;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNic() {
        return nic;
    }

    public List<String> getContactNumber() {
        return contactNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setContactNumber(List<String> contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nic='" + nic + '\'' +
                ", contactNumber=" + contactNumber +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", activeState=" + activeState +
                '}';
    }
}
