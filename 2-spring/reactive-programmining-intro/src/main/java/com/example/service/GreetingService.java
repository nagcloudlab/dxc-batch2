package com.example.service;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Service
public class GreetingService {

    private Scheduler executorService = Schedulers.newBoundedElastic(8, 1000, "greet-service-pool");

    // public String getGreetingMessage() {
    // try {
    // TimeUnit.SECONDS.sleep(2);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // return "Hello";
    // }

    public Mono<String> getGreetingMessage() {
        return Mono.fromCallable(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // System.out.println("service-" + Thread.currentThread());
            return "Hello";
        }).subscribeOn(executorService);
    }

}
