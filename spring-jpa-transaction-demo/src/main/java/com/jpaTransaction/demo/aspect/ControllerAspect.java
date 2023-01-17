package com.jpaTransaction.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class ControllerAspect {

    public static final String ANSI_BLUE = "\u001B[34m", ANSI_RESET = "\u001B[0m";
    Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    private final String pointCutExp1 = "target(com.jpaTransaction.demo.controller.TicketController)";

    @Around(pointCutExp1)
    public Object controllerAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        logger.info(ANSI_BLUE + "Starting : " + joinPoint.getSignature().toShortString() + ANSI_RESET);

        Object r = joinPoint.proceed();

        return r;
    }
}
