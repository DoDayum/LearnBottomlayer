package com.sping.aop.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author DoDayum
 * @date 2021/3/7 20:05
 */
@Aspect
@Component
public class myAdvie {

    private Logger logger = LoggerFactory.getLogger(myAdvie.class);

    //修饰符,返回类型,包名(com.sping.aop.aop.controller).类.方法(参数类型和个数)
    @Pointcut(value = "execution(* com.sping.aop.aop.controller.*.*(..))")//标明这是个切点
    public void myPointcut() {


    }

    //环绕通知
    @Around("myPointcut()")
    public Object myLogger(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getTarget().getClass().toString();//获取类名
        String method = pjp.getSignature().getName();//获取方法名
        Object[] array = pjp.getArgs();//获取方法参数
        ObjectMapper objectMapper = new ObjectMapper();
        logger.info(String.format(" 调用前: %s: %s: 参数: %s", className, method, objectMapper.writeValueAsString(array)));
        Object obj = pjp.proceed();
        logger.info(String.format("调用后: %s: %s: 返回值: %s", className, method, objectMapper.writeValueAsString(obj)));
        return obj;
    }

}
