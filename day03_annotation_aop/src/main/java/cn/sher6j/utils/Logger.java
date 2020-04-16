package cn.sher6j.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 * @author sher6j
 * @create 2020-04-14-17:30
 */
@Component("logger")
@Aspect//表示当前类是一个切面类
public class Logger {

    @Pointcut("execution(* cn.sher6j.service.impl.*.*(..))")
    private void pt1() {
    }

    /**
     * 前置通知
     */
//    @Before("pt1()")
    public void beforePrintLog() {
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了。。。");
    }

    /**
     * 后置通知
     */
//    @AfterReturning("pt1()")
    public void afterReturningPrintLog() {
        System.out.println("后置通知Logger类中的afterReturningPrintLog放法开始记录日志了。。。");
    }

    /**
     * 异常通知
     */
//    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog() {
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了。。。");
    }

    /**
     * 最终通知
     */
//    @After("pt1()")
    public void afterPrintLog() {
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了。。。");
    }

    /**
     * 环绕通知
     */
    @Around("pt1()")
    public Object arroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();//得到方法执行所需参数
            //写在这就表示前置通知
            System.out.println("Logger类中的arroundPrintLog方法执行了。。。前置");
            rtValue = pjp.proceed(); //明确调用业务层方法（切入点方法）
            //写在这就表示后置通知
            System.out.println("Logger类中的arroundPrintLog方法执行了。。。后置");
            return rtValue;

        } catch (Throwable t) {//必须写Throwable，Exception拦不住它
            //写在这就表示异常通知
            System.out.println("Logger类中的arroundPrintLog方法执行了。。。异常");
            throw new RuntimeException(t);
        } finally {
            //写在这就表示最终通知
            System.out.println("Logger类中的arroundPrintLog方法执行了。。。最终");
        }


    }
}
