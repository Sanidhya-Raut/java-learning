package com.sanidhya.day03;

import com.sanidhya.day03.model.Employee;
import com.sanidhya.day03.service.EmployeeAnalyticService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        EmployeeAnalyticService service = new EmployeeAnalyticService();

        Random random = new Random();
        service.getEmployeeList().add(new Employee(random.nextInt(), "Ram", "IT", 2000.00, 25));
        service.getEmployeeList().add(new Employee(random.nextInt(), "Priya", "Finance", 8500.00, 38));
        service.getEmployeeList().add(new Employee(random.nextInt(), "John", "HR", 4500.00, 31));
        service.getEmployeeList().add(new Employee(random.nextInt(), "Aisha", "Marketing", 3200.00, 23));
        service.getEmployeeList().add(new Employee(random.nextInt(), "Vikram", "Operations", 9200.00, 45));
        service.getEmployeeList().add(new Employee(random.nextInt(), "Sarah", "Sales", 2800.00, 26));
        service.getEmployeeList().add(new Employee(random.nextInt(), "Amit", "IT", 5500.00, 29));
        service.getEmployeeList().add(new Employee(random.nextInt(), "Elena", "Finance", 7200.00, 34));
        service.getEmployeeList().add(new Employee(random.nextInt(), "Kabir", "HR", 4100.00, 28));
        service.getEmployeeList().add(new Employee(random.nextInt(), "Chloe", "Marketing", 3900.00, 24));


//        service.printAllEmployees();

//        service.employeesWithSalaryGreaterThan(4000);
//        service.sortEmployeesBySalary();
//        service.sortEmployeesByName();
//        service.printOnlyEmployeeNames();
//        System.out.println(service.countITEmployees());
//        System.out.println(service.findHighestSalary());
//        System.out.println(service.findAvgSalary());
        System.out.println(service.groupEmployeesWithDepartment());



    }

}
