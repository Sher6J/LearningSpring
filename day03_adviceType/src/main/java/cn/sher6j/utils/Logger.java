package cn.sher6j.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 * @author sher6j
 * @create 2020-04-14-17:30
 */
public class Logger {
    /**
     * 前置通知
     */
    public void beforePrintLog() {
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了。。。");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog() {
        System.out.println("后置通知Logger类中的afterReturningPrintLog放法开始记录日志了。。。");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog() {
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了。。。");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog() {
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了。。。");
    }

    /**
     * 环绕通知
     * 问题：
     *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了
     * 分析：
     *      通过对比动态代理中环绕通知代码。发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有
     * 解决：
     *      spring框架为我们提供了一个接口，ProceedingJointPoint，
     *      该接口有一个方法proceed()，此方法就相当于明确调入切入点方法
     *      该接口可以作为环绕通知的方法参数，程序执行时，spring框架会为我们提供接口的实现类供我们使用
     * spring中的环绕通知：
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
     */
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
