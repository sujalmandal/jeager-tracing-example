package com.learn.microserviceb;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracerAspect {

    @Autowired
    Tracer tracer;

    @Around("@annotation(Traced)")
    public Object tracedAnnotationExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        Span span = tracer.buildSpan("execution-time").start();
        long before = System.currentTimeMillis();
        span.setTag("method",joinPoint.getSignature().getName());
        joinPoint.proceed(); // let the method execute
        long after = System.currentTimeMillis();
        span.setTag("total-time-taken(ms)", after-before);
        span.finish();
        return joinPoint.proceed();
    }
}
