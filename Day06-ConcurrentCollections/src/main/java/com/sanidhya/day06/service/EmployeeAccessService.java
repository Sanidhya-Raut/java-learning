package com.sanidhya.day06.service;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EmployeeAccessService {

    private final Map<Integer, AtomicInteger> accessCount;

    public EmployeeAccessService(Map<Integer,AtomicInteger> accessCount){
        this.accessCount=accessCount;
    }

    public void recordAccess(int employeeId){
        this.accessCount.computeIfAbsent(employeeId, key -> new AtomicInteger(0))
                .incrementAndGet();
    }

    public int getAccessCount(int employeeId){
        return accessCount.get(employeeId).get();
    }

    public Map<Integer,AtomicInteger> getAllAccessCounts(){
        return accessCount;
    }
}
