package com.example.furama.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {
    private Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Pointcut("execution(* com.example.furama.service.StudentService.*(..))")
    public void studentService(){};

    @Pointcut("execution(* com.example.furama.service.StudentService.delete(..))")
    public void studentServiceDelete(){};

    @Before("studentService()")
    public void writeLog(JoinPoint point) throws Exception {
        String methodName = point.getSignature().getName();
        logger.info("Before call method: " + methodName);
    }

    @After("execution (* com.example.furama.service.StudentService.fi*(..)) || execution(* codegym.vn.springboot.service.StudentService.delete(..))")
    public void writeLogFindAll(JoinPoint point) throws Exception {
        String methodName = point.getSignature().getName();
        logger.info("After call method: " + methodName);
    }
    com.example.furama
    @AfterThrowing(value = "execution (* v.service.StudentService.findAll())", throwing = "e")
    public void writeMessageError(JoinPoint point, Exception e) throws Exception {
        String methodName = point.getSignature().getName();
        logger.info("After throwing call method: " + methodName);
        logger.warning(e.getStackTrace().toString());
    }

    @Around("studentService()")
    public Object getLogAround(ProceedingJoinPoint point) throws Throwable {
        String methodName = point.getSignature().getName();
        logger.info("Around before call method: " + methodName);
        Object result = point.proceed();
        logger.info("Around after call method: " + methodName);
        return result;
    }
}
