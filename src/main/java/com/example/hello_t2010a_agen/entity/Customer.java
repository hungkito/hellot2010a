package com.example.hello_t2010a_agen.entity;

import com.example.hello_t2010a_agen.util.DateTimeHelper;

import java.time.LocalDateTime;

public class Customer {
    private String Rollnumber;
    private String Name;
    private String Phone;
    private String Image;
    private LocalDateTime dob;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int status; // xoá mềm

    public Customer(String rollnumber, String name, String phone, String image, LocalDateTime dob) {
        Rollnumber = rollnumber;
        Name = name;
        Phone = phone;
        Image = image;
        this.dob = dob;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Rollnumber='" + Rollnumber + '\'' +
                ", Name='" + Name + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Image='" + Image + '\'' +
                ", dob=" + dob +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                '}';
    }

    public String getRollnumber() {
        return Rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        Rollnumber = rollnumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDobString() {
        if(this.dob != null){
            return DateTimeHelper.convertLocalDateTimeToString(this.dob);
        }
        return "";
    }
}
