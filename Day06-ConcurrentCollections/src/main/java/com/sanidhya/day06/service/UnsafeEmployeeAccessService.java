package com.sanidhya.day06.service;

import java.util.Map;

public class UnsafeEmployeeAccessService implements AccessService{
    private final Map<Integer, Integer> accessCount;

    public UnsafeEmployeeAccessService(Map<Integer,Integer> accessCount){
        this.accessCount=accessCount;
    }

    public void recordAccess(int employeeId){
        Integer empCount = accessCount.get(employeeId);
        if(empCount == null) empCount=0;
        empCount +=1;
        accessCount.put(employeeId,empCount);
    }

    public int getAccessCount(int employeeId){
        return accessCount.get(employeeId);
    }

    public Map<Integer,Integer> getAllAccessCounts(){
        return accessCount;
    }

}
