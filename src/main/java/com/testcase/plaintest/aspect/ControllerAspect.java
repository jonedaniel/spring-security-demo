package com.testcase.plaintest.aspect;

import com.testcase.plaintest.exception.ServiceException;
import com.testcase.plaintest.util.UserContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Title: HttpAspect
 * Description: aspect 用于controller日志记录
 *
 * @author zhaomenghui
 * @version 2018/5/2
 */
@Aspect
@Component
public class ControllerAspect {

    private final static Logger logger = LoggerFactory.getLogger(ControllerAspect.class);


    @Pointcut("execution(public * com.testcase.plaintest.controller.*.*(..)) && !execution(public * com.testcase.plaintest.controller.*.init(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest       request    = attributes.getRequest();

        //url method ip
        logger.warn("\n>>>>>");
        logger.warn("请求相关信息: url={}，method={}，ip={},class_method={}, args={}", request.getRequestURL(), request.getMethod(), request.getRemoteAddr(),joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(), joinPoint.getArgs());
        logger.warn("username={},authorizes={}",UserContext.getUsername(),UserContext.getAuthorizes());
    }

    @After("log()")
    public void doAfter() {
//        logger.warn("利用AOP记录每次请求完成后的信息");
    }

    @AfterThrowing(value = "log()",throwing = "e")
    public void afterThrowing(Throwable e) {
        if (e instanceof ServiceException) {
            logger.error(((ServiceException) e).getInfo());
        } else {
            logger.error("异常全限定名{},异常message:{}", e.getClass().getName(),e.getMessage());
        }
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.warn("response={}", object == null ? "null" : object.toString()
                +"\n<<<<<");
    }

}
