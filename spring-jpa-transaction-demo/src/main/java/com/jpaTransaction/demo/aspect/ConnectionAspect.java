package com.jpaTransaction.demo.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.logging.Logger;

public class ConnectionAspect implements InvocationHandler {

    public static final String ANSI_OLIVE_GREEN= "\u001B[38;5;112m", ANSI_RESET = "\u001B[0m";
    Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    Connection connection;

    public ConnectionAspect(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        logger.info(ANSI_OLIVE_GREEN + "Starting : " + method.getName() + ANSI_RESET);

        return method.invoke(connection, args);
    }
}
