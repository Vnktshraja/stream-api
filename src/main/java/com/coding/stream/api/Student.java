package com.coding.stream.api;

import java.util.Date;

public class Student {

    private Integer id;
    private String name;
    private Date dob;
    private String mobile;
    private String address;

    public Student() {
    }

    public Student(Integer id, String name, Date dob, String mobile, String address) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.mobile = mobile;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = String.valueOf(mobile);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", mobile=" + mobile +
                ", address='" + address + '\'' +
                '}';
    }
}
