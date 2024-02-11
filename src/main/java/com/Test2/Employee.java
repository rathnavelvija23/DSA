package com.Test2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {

    private Long empId;
    private String empName;
    private BigDecimal salary;
    private String dateOfBirth;
    private Integer deptId;


    static class Service
    {
        static List<Employee> getEmployeesOrderByDobDescending(List<Employee> employeeList)
        {
         List<Employee> list = employeeList.stream().sorted(Comparator.comparing(Employee::getDateOfBirth).reversed())
                 .collect(Collectors.toList());
            return null;
        }
        static List<Long> getEmployeeIdsHavingAnnualSalaryLessThan1500(List<Employee> employeeList)
        {
          List<Employee> list2=   employeeList.stream().filter( e-> e.getSalary().intValue() < 1500).collect(Collectors.toList());
          List<Long> listSal = new ArrayList<>();
          for(Employee emp:list2){
              listSal.add(emp.getSalary().longValue());
          }
          return listSal;
        }

        static List<Double> getAverageSalaryForEachDepartment(List<Employee> employeeList)
        {
            return null;
        }
    }public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setEmpId(1L);
        e1.setSalary(BigDecimal.valueOf(100L));
        e1.setEmpName("Raghav");
        e1.setDateOfBirth("1994-08-18");
        e1.setDeptId(1);

        Employee e2 = new Employee();
        e2.setEmpId(2L);
        e2.setSalary(BigDecimal.valueOf(120L));
        e2.setEmpName("James");
        e2.setDateOfBirth("1991-06-21");
        e2.setDeptId(1);


        Employee e3 = new Employee();
        e3.setEmpId(3L);
        e3.setSalary(BigDecimal.valueOf(5430L));
        e3.setEmpName("Steve");
        e3.setDateOfBirth("1986-05-15");
        e3.setDeptId(2);

        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

        Service.getEmployeesOrderByDobDescending(list);
        System.out.println(Service.getAverageSalaryForEachDepartment(list));
        System.out.println(Service.getEmployeeIdsHavingAnnualSalaryLessThan1500(list));

    }

    public Long getEmpId() {
        return empId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", deptId=" + deptId +
                '}';
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}