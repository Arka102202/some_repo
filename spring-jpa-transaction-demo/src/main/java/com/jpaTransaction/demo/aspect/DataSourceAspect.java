package com.jpaTransaction.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.logging.Logger;

@Aspect
@Component
public class DataSourceAspect {

    public static final String ANSI_ORANGE= "\u001b[38;5;208m", ANSI_RESET = "\u001B[0m";
    Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    private final String pointCutExp1 = "target(javax.sql.DataSource)";

    @Around(pointCutExp1)
    public Object controllerAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        logger.info(ANSI_ORANGE + "Starting : " + joinPoint.getSignature().toShortString() + ANSI_RESET);

        Object r = joinPoint.proceed();

        if (r instanceof Connection) {
            return Proxy.newProxyInstance(
                    Connection.class.getClassLoader(), new Class[]{Connection.class}, new ConnectionAspect((Connection) r));
        }

        return r;
    }
}
