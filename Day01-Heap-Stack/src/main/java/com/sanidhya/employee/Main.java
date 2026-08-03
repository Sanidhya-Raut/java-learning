package com.sanidhya.employee;

import com.sanidhya.employee.model.Employee;
import com.sanidhya.employee.service.EmployeeService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> empList = new ArrayList<>();
        EmployeeService service = new EmployeeService();
        empList.add(new Employee(1,"Ram", 1200.90));
        empList.add(new Employee(2,"Rahim", 1000.90));
        empList.add(new Employee(3,"Rohan", 2000.90));
        empList.add(new Employee(4,"Rajesh", 5200.90));
        empList.add(new Employee(5,"Ramakant", 78200.90));


        for (Employee emp: empList){
            service.display(emp);
        }
        for (Employee emp: empList){
            service.increaseSalary(10d,emp.getSalary());
        }
        System.out.println("--------------10% Increase--------");
        for (Employee emp: empList){
            service.display(emp);
        }
    }
}

