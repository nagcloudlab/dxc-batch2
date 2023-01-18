package org.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class TransactionAspect {

    private static Logger logger = LoggerFactory.getLogger("transfer-service");
//
//    @Before(value = "execution(void transfer(double,String,String))")
//    public void beginTransaction(JoinPoint joinPoint) {
//        logger.info("beginTransaction - " + joinPoint.toShortString());
//    }
//
//    @AfterReturning(value = "execution(void transfer(double,String,String))", returning = "r")
//    public Object commitTransaction(JoinPoint joinPoint, Object r) {
//        logger.info("commitTransaction - " + joinPoint.toShortString());
//        return r;
//    }
//
//    @AfterThrowing(value = "execution(void transfer(double,String,String))", throwing = "e")
//    public Object rollbackTransaction(JoinPoint joinPoint, Throwable e) throws Throwable {
//        logger.info("rollbackTransaction - " + joinPoint.toShortString());
//        throw e;
//    }
//
//    @After(value = "execution(void transfer(double,String,String))")
//    public void closeConnection(JoinPoint joinPoint) {
//        logger.info("closeConnection - " + joinPoint.toShortString());
//    }

    @Around(value = "execution(@org.example.annotation.Transactional * *(..))")
    public void manageTransaction(ProceedingJoinPoint joinPoint) {
        try {
            logger.info("beginTransaction - " + joinPoint.toShortString());
            joinPoint.proceed();
            logger.info("commitTransaction - " + joinPoint.toShortString());
        } catch (Throwable e) {
            logger.info("rollbackTransaction - " + joinPoint.toShortString());
        } finally {
            logger.info("closeConnection - " + joinPoint.toShortString());
        }
    }


}
