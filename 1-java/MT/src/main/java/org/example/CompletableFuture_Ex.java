package org.example;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFuture_Ex {
    public static void main(String[] args) {

        CompletableFuture<String> cf = new CompletableFuture<>();

        ExecutorService io = Executors.newFixedThreadPool(8);
        ExecutorService computation = Executors.newFixedThreadPool(8);

        cf.supplyAsync(() -> {
                    // Get Order Details
                    return "order";
                }, io)
                .thenApplyAsync(order -> {
                    // Enrich Order Details
                    return order.toUpperCase();
                }, computation)
                .thenApplyAsync(order -> {
                    // Email
                    return order;
                }, io);


    }
}
