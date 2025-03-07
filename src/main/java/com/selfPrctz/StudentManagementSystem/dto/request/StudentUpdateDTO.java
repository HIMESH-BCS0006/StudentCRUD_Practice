package com.selfPrctz.StudentManagementSystem.dto.request;

import java.util.List;

public class StudentUpdateDTO {
    private long id;
    private List<String> contactNumber;
    private String dateOfBirth;
    private String address;


    public StudentUpdateDTO() {
    }

    public StudentUpdateDTO(long id, List<String> contactNumber, String dateOfBirth, String address) {
        this.id = id;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(List<String> contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentUpdateDTO{" +
                "id=" + id +
                ", contactNumber=" + contactNumber +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
