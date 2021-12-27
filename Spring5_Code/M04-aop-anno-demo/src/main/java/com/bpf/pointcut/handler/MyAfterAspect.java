package com.bpf.pointcut.handler;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Aspect 切面类的注解，用于标识当前类是切面类。
 *
 * 切面类内定义切面方法，并使用 通知注解（时间） 和 切入点表达式（位置） 进行标注。
 *
 * @Pointcut 定义切入点表达式
 *  1) 方法定义规则
 *      * void 方法名()
 *
 *  2) 通知注解的使用
 *   属性：
 *     value        切入点表达式
 *
 *   特点：
 *     定义可以复用的切入点表达式，方法名可以看作是切入点表达式的别名。
 *
 */
@Component
@Aspect
public class MyAfterAspect {

    @Pointcut("execution(* *..SomeServiceImpl.do*(..) )")
    private void doMethods() {}

    @After(value = "doMethods()")
    public void process() {
        System.out.println("[MyAfterAspect] （最终通知） 目标方法的最后执行：记录完成时间 " + new Date());
    }

    @AfterThrowing(value = "doMethods()", throwing = "ex")
    public void process(Exception ex) {
        System.out.println("[MyAfterThrowingAspect] （异常通知） 目标方法抛出异常时执行：");
        System.out.println("\t记录执行时间: " + new Date());
        System.out.println("\t记录异常信息：" + ex.getMessage());
        System.out.println("\t记录异常类型：" + ex.getClass());
    }
}
