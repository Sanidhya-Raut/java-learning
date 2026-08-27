package com.sanidhya.day06;

import com.sanidhya.day06.model.Employee;
import com.sanidhya.day06.service.EmployeeAccessService;
import com.sanidhya.day06.task.AccessTask;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main   {
    public static void main(String[] args) {

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();

        employee1.setEmployeeId(1);
        employee2.setEmployeeId(2);
        employee3.setEmployeeId(3);

        Map<Integer, AtomicInteger> map = new ConcurrentHashMap<>();

        EmployeeAccessService employeeAccessService = new EmployeeAccessService(map);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        try{

            Future<?> future1 = executorService.submit(new AccessTask(employee1,employeeAccessService));
            Future<?> future2 = executorService.submit(new AccessTask(employee2,employeeAccessService));
            Future<?> future3 = executorService.submit(new AccessTask(employee3,employeeAccessService));
            Future<?> future4 = executorService.submit(new AccessTask(employee1,employeeAccessService));
            Future<?> future5 = executorService.submit(new AccessTask(employee2,employeeAccessService));

            future1.get();
            future2.get();
            future3.get();
            future4.get();
            future5.get();


        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }catch (ExecutionException e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();

        }


        System.out.println("Employee Access Counts:");
        AtomicInteger count = new AtomicInteger();
        map.forEach((key,val) -> {
            count.addAndGet(val.get());
            System.out.println("Employee "+key+" -> "+val.get());
        });
        System.out.println("Total accesses: "+count.get());
    }
}
