package org.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class LoggingAspect {

    private static Logger logger = LoggerFactory.getLogger("transfer-service");


    @Before(value = "execution(* transfer1(..))")
    public void log(JoinPoint joinPoint) {
        logger.info("before log - " + joinPoint.toShortString());
    }

}
