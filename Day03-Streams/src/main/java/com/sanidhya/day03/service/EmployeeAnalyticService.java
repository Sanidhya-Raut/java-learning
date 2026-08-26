package com.sanidhya.day03.service;

import com.sanidhya.day03.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeAnalyticService {

    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void printAllEmployees(){
        System.out.println(employeeList);
    }

    public void employeesWithSalaryGreaterThan(double salary){
        employeeList.stream().filter(s -> s.getSalary() > salary).forEach(System.out::println);
    }

    public void sortEmployeesBySalary(){
        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);
    }

    public List<Employee> sortEmployeesByName(boolean isReversed) {
        Comparator<Employee> comparator = Comparator.comparing(Employee::getName);
        if(isReversed) {
            comparator = comparator.reversed();
        }
        return employeeList.stream().sorted(comparator).collect(Collectors.toList());
    }

    public void printOnlyEmployeeNames() {
        employeeList.stream().map(Employee::getName).forEach(System.out::println);
    }

    public long countITEmployees() {
        return employeeList.stream().filter(employee -> employee.getDepartment().equals("IT")).count();
    }

    public Employee findHighestSalary() {
        return employeeList.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
    }

    public double findAvgSalary() {
        return employeeList.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
    }

    public Map<String,List<Employee>> groupEmployeesWithDepartment() {
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public double findSecondHighestSalary() {
        return employeeList.stream().map(Employee::getSalary).distinct()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0.0);
    }

    public List<String> removeDuplicateDepartments(){
        return  employeeList.stream().map(Employee::getDepartment).distinct().toList();
    }

    public List<Employee> threeHighestPaidEmployees(){
        return employeeList.stream().sorted(Comparator.comparing(Employee::getSalary)
                .reversed()).limit(3).toList();
    }
}
