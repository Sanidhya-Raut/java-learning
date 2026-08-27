package com.sanidhya.day06.task;

import com.sanidhya.day06.model.Employee;
import com.sanidhya.day06.service.AccessService;

public class AccessTask implements Runnable{

    private final AccessService service;
    private final Employee employee;

    public AccessTask(Employee employee,AccessService accessService){
        this.employee = employee;
        this.service = accessService;
    }

    @Override
    public void run() {
        for(int i=0;i<2000;i++){
            service.recordAccess(employee.getEmployeeId());
        }
    }
}
