package com.DSA.Java8.Map;

import java.time.LocalDate;

public class Employee {
    private int empId;
    private String name;
    private String city;
    private LocalDate date;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", date=" + date +
                '}';
    }

    public Employee(int empId, String name, String city, LocalDate date) {
        this.empId = empId;
        this.name = name;
        this.city = city;
        this.date = date;
    }
}
