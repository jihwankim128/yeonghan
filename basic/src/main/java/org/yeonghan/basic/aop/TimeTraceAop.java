package org.yeonghan.basic.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* org.yeonghan.basic..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.getSignature());
        try {
            return joinPoint.proceed();
        } finally {
            long timeMs = System.currentTimeMillis() - start;
            System.out.println("END: " + joinPoint.getSignature() + " TIME: " + timeMs + "ms");
        }
    }

}
