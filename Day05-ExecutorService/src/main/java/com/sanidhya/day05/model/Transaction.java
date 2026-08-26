package com.sanidhya.day05.model;

public class Transaction {
    private final int transactionId;

    public Transaction(int id){
        this.transactionId = id;
    }

    public void display(){
        System.out.println("Transaction "+ transactionId +" processed by "+Thread.currentThread().getName());
    }

    public String getTransactionStatus(){
        if(transactionId %2 ==0) return "SUCCESS";
        else return "FAILED";
    }
}
