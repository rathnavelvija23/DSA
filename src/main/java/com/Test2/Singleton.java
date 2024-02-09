package com.Test2;

 class User {

    private static User instance = null;

    private String userId;
    private String name;
    private Integer salary;
    private Integer age;
    private String jobTitle;

    // Private constructor to prevent instantiation outside of this class
    private User() {
        // Initialize your instance variables here
    }

    // Static method to get the singleton instance
    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    // Getter and setter methods for the instance variables go here

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}

public class Singleton {

    public static void main(String[] args) {
        User user1 = User.getInstance();
        User user2 = User.getInstance();

        user1.setUserId("1");
        user2.setUserId("2");

        System.out.println(user1.getUserId() +":::::::"+user2.getUserId());


    }
}
