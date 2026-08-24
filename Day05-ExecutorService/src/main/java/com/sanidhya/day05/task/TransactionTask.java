package com.sanidhya.day05.task;

import com.sanidhya.day05.model.Transaction;

import java.util.concurrent.Callable;

public class TransactionTask implements Callable<String> {

    Transaction transaction;

    public TransactionTask(int id){
        this.transaction = new Transaction(id);
    }

    @Override
    public String call() {
        transaction.display();
        return  transaction.getTransactionStatus();
    }
}
