package com.sanidhya.employee.service;

import com.sanidhya.employee.model.Employee;

public class EmployeeService {


    public void display(Employee emp){
        System.out.println(emp.toString());
    }

    public double increaseSalary(Double percentage,double salary){
        double increasceSalary = salary*percentage/100;
        salary += increasceSalary;
        return salary;
    }
}
