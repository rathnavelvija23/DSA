package com.DSA.Java8;


import java.time.LocalDate;

public class Employee1 {

    private String name;

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", date=" + date +
                ", age=" + age +
                '}';
    }

    private String city;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    private LocalDate date;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee1(String name, String city, int age, LocalDate date) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.date = date;
    }

    private int age;

    public Employee1 modifyDate(){
        return new Employee1(name,city,age,date.plusDays(1));
    }
}
