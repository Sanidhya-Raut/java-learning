package com.sanidhya.day05.service;

import com.sanidhya.day05.task.TransactionTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TransactionService {
    public void work() {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<String>> futures = new ArrayList<>();

        futures.add(executorService.submit(new TransactionTask(1)));
        futures.add(executorService.submit(new TransactionTask(2)));
        futures.add(executorService.submit(new TransactionTask(3)));
        futures.add(executorService.submit(new TransactionTask(4)));
        futures.add(executorService.submit(new TransactionTask(5)));

        try {
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e);
        }finally {
            executorService.shutdown();
        }

    }

}
