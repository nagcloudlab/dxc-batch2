package com.example.web;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.GreetingService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService greetingService;

    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    public @ResponseBody Mono<String> doGreeting() {
        System.out.println(Thread.currentThread());
        return greetingService.getGreetingMessage();
    }

}
