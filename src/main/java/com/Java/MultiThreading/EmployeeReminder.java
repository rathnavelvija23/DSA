package com.Java.MultiThreading;

import com.Java.MultiThreading.DTO.Employee;
import com.Java.MultiThreading.Database.DataBase;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class EmployeeReminder {
    //Fetchemployee -> // filter(today joined employee) -> // check whether mandatory training is completed
    // get employee emails -> // send mail as notification
    public CompletableFuture<Void> fetchEmployee(){

        CompletableFuture<Void> voidEmp = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread Name for Fetch:"+Thread.currentThread().getName());
           List<Employee> empList = DataBase.getEmployee();
           System.out.println(empList.size());
           return empList;
        }).thenApply((employees)-> {
            System.out.println("Thread Name for filter new joiner:"+Thread.currentThread().getName());
            System.out.println(employees.stream().count());
            return employees.stream().filter(e -> "TRUE".equals(e.getNewJoiner()) ).collect(Collectors.toList());
        }).thenApply( (employees) ->{
            System.out.println("Thread Name for Training not completed:"+Thread.currentThread().getName());
           System.out.println(employees.size());
            return employees.stream().filter(e -> "TRUE".equals(e.getLearningPending())).collect(Collectors.toList());
        }).thenApply((employees) -> {
           System.out.println("Thread Name for getting emails Ids for employee:"+Thread.currentThread().getName());
           System.out.println(employees.size());
            return employees.stream().map( Employee::getEmail).collect(Collectors.toList());
        }).thenAccept( (emails) -> {
            System.out.println("Thread Name for sending emails :"+Thread.currentThread().getName());
            System.out.println(emails.size());
            emails.forEach(EmployeeReminder::sendEmail);
        });

return voidEmp;
    }

    public static void sendEmail(String email){
        System.out.println("Email send:"+email);
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        EmployeeReminder employeeReminder = new EmployeeReminder();
        employeeReminder.fetchEmployee().get();

    }
}
