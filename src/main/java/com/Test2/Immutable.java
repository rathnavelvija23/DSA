package com.Test2;


final class User1 {

    private final String userId;
    private final String name;
    private final Integer salary;
    private final Integer age;
    private final String jobTitle;

    // Private constructor to initialize all fields
    private User1(String userId, String name, Integer salary, Integer age, String jobTitle) {
        this.userId = userId;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.jobTitle = jobTitle;
    }

    // Static factory method to create instances
    public static User1 getInstance(String userId, String name, Integer salary, Integer age, String jobTitle) {
        return new User1(userId, name, salary, age, jobTitle);
    }

    // Add getters for all fields
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getAge() {
        return age;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}

public class Immutable {

    public static void main(String[] args) {
      //  User1 user = new User1("1","vija",2,400,"new");

        User1 user= User1.getInstance("1","vija",2,400,"new");
        System.out.println(user.getUserId());

    }
}
