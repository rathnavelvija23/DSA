package com.DSA.practice.v1.ListOperations;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
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
            List<Employee> list = employeeList.stream().sorted(Comparator.comparing(Employee::getDateOfBirth).reversed()).collect(Collectors.toList());

            return list;
        }
        static List<Long> getEmployeeIdsHavingAnnualSalaryLessThan1500(List<Employee> employeeList)
        {
            return employeeList.stream().filter(a -> a.salary.intValue() < 1500).map( a -> a.getSalary().longValue()).collect(Collectors.toList());

        }

        static List<Double> getAverageSalaryForEachDepartment(List<Employee> employeeList)
        {
            return employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.averagingDouble(e -> e.getSalary().doubleValue())))
                    .entrySet().stream().map(a -> a.getValue()).collect(Collectors.toList());
        }

        static Integer getFirstRepeatedORFirstDuplicateDept(List<Employee> employeeList)
        {
            return employeeList.stream().collect(Collectors.groupingBy( e-> e.getDeptId(),LinkedHashMap::new,Collectors.counting()))
                    .entrySet().stream().filter( e-> e.getValue() >1 ).map(e -> e.getKey()).findFirst().get();

        }

        static Integer getSecondRepeatedORSecondDuplicateDept(List<Employee> employeeList)
        {
         return employeeList.stream()
                    .collect(Collectors.groupingBy(e -> e.getDeptId(), LinkedHashMap::new, Collectors.counting()))
                            .entrySet().stream().filter(a -> a.getValue() > 1).map( a -> a.getKey()).skip(1)
                         .findFirst().get();
        }

        static Integer getNonRepeatedORUniqueSalary(List<Employee> employeeList)
        {

            return employeeList.stream().collect(Collectors
                    .groupingBy( e -> e.getSalary(), LinkedHashMap::new , Collectors.counting()))
                    .entrySet().stream().filter( e-> e.getValue() == 1).map(Map.Entry::getKey)
                    .findFirst().get().intValue();

        }

        static LinkedHashMap<Long, Employee> addonedaytoDOBAndModifyDeptid(List<Employee> employeeList){

            LinkedHashMap<Long, Employee> map = employeeList.stream().collect(Collectors.toMap(e -> e.getEmpId()
                    , e -> {
                LocalDate date = LocalDate.parse(e.getDateOfBirth());
                e.setDateOfBirth(date.plusDays(1).toString());
                if (e.getDeptId().equals(2))
                    e.setDeptId(8);
                return e;
            }, (v1, v2) -> v1, LinkedHashMap::new));

            return map;
        }
    }

    public static void main(String[] args) {
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
        e2.setDeptId(2);


         Employee e3 = new  Employee();
        e3.setEmpId(3L);
        e3.setSalary(BigDecimal.valueOf(5430L));
        e3.setEmpName("Steve");
        e3.setDateOfBirth("1986-05-15");
        e3.setDeptId(2);

        Employee e4 = new  Employee();
        e4.setEmpId(4L);
        e4.setSalary(BigDecimal.valueOf(1430L));
        e4.setEmpName("Smith");
        e4.setDateOfBirth("1996-05-15");
        e4.setDeptId(4);

        Employee e5 = new  Employee();
        e5.setEmpId(4L);
        e5.setSalary(BigDecimal.valueOf(1430L));
        e5.setEmpName("Smith");
        e5.setDateOfBirth("1996-05-15");
        e5.setDeptId(4);


        List< Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);

        Service.getEmployeesOrderByDobDescending(list).forEach(System.out::println);
        System.out.println(Service.getAverageSalaryForEachDepartment(list));
        System.out.println(Service.getEmployeeIdsHavingAnnualSalaryLessThan1500(list));
        System.out.println(Service.getFirstRepeatedORFirstDuplicateDept(list));
        System.out.println(Service.getSecondRepeatedORSecondDuplicateDept(list));
        System.out.println(Service.getNonRepeatedORUniqueSalary(list));
        System.out.println(Service.addonedaytoDOBAndModifyDeptid(list));

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