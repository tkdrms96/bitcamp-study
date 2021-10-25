package com.tobabogi.demo.eventboard.aop;


import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Log4j2
@Component
public class EventTimeLogAspect {

    {
        log.info("TimeLogAspect.................");
        log.info("TimeLogAspect.................");
        log.info("TimeLogAspect.................");
        log.info("TimeLogAspect.................");
        log.info("TimeLogAspect.................");
    }

    @Before("execution(* com.tobabogi.demo.eventboard.service.*.getDTOList(..))")
    public void logBefore(JoinPoint joinPoint){
        log.info("logBefore...........................");

        log.info(joinPoint.getTarget());// 실제 객체
        log.info(Arrays.toString(joinPoint.getArgs()));

        log.info("logBefore...........................END");
    }

    @AfterReturning("execution(* com.tobabogi.demo.eventboard.service.*.getDTOList(..))")
    public void logAfter(){
        log.info("logAfter...........................");
    }
}
