package org.example.web;

import org.example.service.AccountBalanceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(value = { AccountBalanceException.class })
    public String handleBalanceException(Throwable t) {
        return "redirect:transfer-form.html";
    }
}
