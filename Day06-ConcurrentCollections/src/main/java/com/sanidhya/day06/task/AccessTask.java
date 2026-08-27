package com.sanidhya.day06.task;

import com.sanidhya.day06.model.Employee;
import com.sanidhya.day06.service.EmployeeAccessService;

public class AccessTask implements Runnable{

    private final EmployeeAccessService service;
    private final Employee employee;

    public AccessTask(Employee employee,EmployeeAccessService employeeAccessService){
        this.employee = employee;
        this.service = employeeAccessService;
    }

    @Override
    public void run() {
        for(int i=0;i<2000;i++){
            service.recordAccess(employee.getEmployeeId());
        }
    }
}
