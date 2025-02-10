package com.booking.aspect;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    // @Around("execution(* com.booking..*(..)))")
    public Object logMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        log.info(">> {}() - {}", methodName, Arrays.toString(args));
        Object result = joinPoint.proceed();
        log.info("<< {}() - {}", methodName, result);
        var methodSignature = (MethodSignature) joinPoint.getSignature();

        final var stopWatch = new StopWatch();

        // calculate method execution time
        stopWatch.start();
        result = joinPoint.proceed();
        stopWatch.stop();
        // Log method execution time
        log.info("TECHGEEKNEXT - Spring Boot Logging AOP EXAMPLE - Execution time of "
                + methodSignature.getDeclaringType().getSimpleName() // Class Name
                + "." + methodSignature.getName() + " " // Method Name
                + ":: " + stopWatch.getTotalTimeMillis() + " ms");

        return result;
    }

    @Around("execution(* com.booking.handler..*(..)))")
    public Object handler(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getClass().getName();

        log.info("handler className >> {}() - {}", className, Arrays.toString(args));
        log.info("handler >> {}() - {}", methodName, Arrays.toString(args));
        Object result = joinPoint.proceed();
        log.info("handler << {}() - {}", methodName, result);
        var methodSignature = (MethodSignature) joinPoint.getSignature();

        final var stopWatch = new StopWatch();

        // calculate method execution time
        stopWatch.start();
        result = joinPoint.proceed();
        stopWatch.stop();
        // Log method execution time
        log.info("TECHGEEKNEXT - Spring Boot Logging AOP EXAMPLE - Execution time of "
                + methodSignature.getDeclaringType().getSimpleName() // Class Name
                + "." + methodSignature.getName() + " " // Method Name
                + ":: " + stopWatch.getTotalTimeMillis() + " ms");

        return result;
    }
}
