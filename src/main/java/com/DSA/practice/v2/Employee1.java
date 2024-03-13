package com.DSA.practice.v2;




import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Employee1 {

    private Long empId;
    private String empName;
    private BigDecimal salary;
    private String dateOfBirth;
    private Integer deptId;


    static class Service
    {
        static List<Employee1> getEmployeesOrderByDobDescending(List<Employee1> employeeList) {


            return employeeList.stream().sorted(Comparator.comparing(Employee1::getDateOfBirth).reversed()).collect(Collectors.toList());
        }

        static List<Long> getEmployeeIdsHavingAnnualSalaryLessThan1500(List<Employee1> employeeList)
        {

           return employeeList.stream().filter( c-> c.getSalary().intValue() <=1500).map( c -> c.getEmpId()).collect(Collectors.toList());



        }

        static List<Double> getAverageSalaryForEachDepartment(List<Employee1> employeeList)
        {
            Map<Long, Double> list = employeeList.stream().collect(Collectors.groupingBy(Employee1::getEmpId, Collectors.averagingInt(e -> e.getSalary().intValue())));
            List<Double> list1 = list.entrySet().stream().map(c -> c.getValue()).collect(Collectors.toList());
            System.out.println(list1+"--"+list1.hashCode()+"--"+list.hashCode());
            return list1;


        }

        static Integer getFirstRepeatedORFirstDuplicateDept(List<Employee1> employeeList)
        {
            Map<Integer, Long> map = employeeList.stream().collect(Collectors.groupingBy(Employee1::getDeptId, LinkedHashMap::new, Collectors.counting()));
            System.out.println(map);
            System.out.println(map.entrySet().stream().filter( c -> c.getValue() >1).map( c-> c.getKey()).skip(1).limit(1).findAny().get());
            return null;
        }

        static Integer getSecondRepeatedORSecondDuplicateDept(List<Employee1> employeeList)
        {

            return null;
        }

   static Integer getNonRepeatedORUniqueSalary(List<Employee1> employeeList)
        {
            return null;

        }

        static LinkedHashMap<Long, Employee1> addonedaytoDOBAndModifyDeptidasfivetosevenGetasMap(List<Employee1> employeeList) {


            LinkedHashMap<Long, Employee1> output = employeeList.stream().collect(Collectors.toMap(e -> e.getEmpId(), e -> {
                LocalDate date = LocalDate.parse(e.getDateOfBirth()).plusDays(2);
                e.setDateOfBirth(date.toString());
                if (e.getDeptId() == 4) {
                    e.setDeptId(7);
                }
                return e;
            }, (v1, v2) -> v2, LinkedHashMap::new));
            return output;
        }


    }

    public static void main(String[] args) {
        Employee1 e1 = new Employee1();
        e1.setEmpId(1L);
        e1.setSalary(BigDecimal.valueOf(110L));
        e1.setEmpName("Raghav");
        e1.setDateOfBirth("1994-08-18");
        e1.setDeptId(1);

        Employee1 e2 = new Employee1();
        e2.setEmpId(2L);
        e2.setSalary(BigDecimal.valueOf(120L));
        e2.setEmpName("James");
        e2.setDateOfBirth("1991-06-21");
        e2.setDeptId(2);


         Employee1 e3 = new Employee1();
        e3.setEmpId(3L);
        e3.setSalary(BigDecimal.valueOf(5430L));
        e3.setEmpName("Steve");
        e3.setDateOfBirth("1986-05-15");
        e3.setDeptId(2);

        Employee1 e4 = new Employee1();
        e4.setEmpId(4L);
        e4.setSalary(BigDecimal.valueOf(1430L));
        e4.setEmpName("Smith");
        e4.setDateOfBirth("1996-05-15");
        e4.setDeptId(4);

        Employee1 e5 = new Employee1();
        e5.setEmpId(4L);
        e5.setSalary(BigDecimal.valueOf(1430L));
        e5.setEmpName("Smith");
        e5.setDateOfBirth("2016-05-15");
        e5.setDeptId(4);


        List<Employee1> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);

        System.out.println(Service.getEmployeesOrderByDobDescending(list));
        System.out.println(Service.getEmployeeIdsHavingAnnualSalaryLessThan1500(list));
        System.out.println(Service.getAverageSalaryForEachDepartment(list));
        System.out.println(Service.getFirstRepeatedORFirstDuplicateDept(list));
        System.out.println(Service.getSecondRepeatedORSecondDuplicateDept(list));
        System.out.println(Service.getNonRepeatedORUniqueSalary(list));
        System.out.println(Service.addonedaytoDOBAndModifyDeptidasfivetosevenGetasMap(list));


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