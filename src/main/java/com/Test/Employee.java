package com.Test;

public class Employee {
    private int empid;
    private String empName;

    public int getEmpid() {
        return empid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", empName='" + empName + '\'' +
                '}';
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Employee(int empid, String empName) {
        this.empid = empid;
        this.empName = empName;
    }
}
