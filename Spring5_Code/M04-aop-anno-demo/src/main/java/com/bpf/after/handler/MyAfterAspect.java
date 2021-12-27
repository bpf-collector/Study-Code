package com.bpf.after.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Aspect 切面类的注解，用于标识当前类是切面类。
 *
 * 切面类内定义切面方法，并使用 通知注解（时间） 和 切入点表达式（位置） 进行标注。
 *
 * @After 最终通知
 *  1) 方法定义规则
 *      public void 方法名()
 *    参数：无参数
 *  2) 通知注解的使用
 *   属性：
 *     value        切入点表达式
 *
 *   特点：
 *     在目标方法的最后执行，无论有没有抛出异常。
 *     适合做一些收尾工作，如清除缓存，关闭流等。
 *
 *   执行流程类似于：
 *     try {
 *         SomeServiceImpl.do*(..)
 *     } finally {
 *         MyAfterAspect.process(e)
 *     }
 */
@Component
@Aspect
public class MyAfterAspect {

    @After(value = "execution(* *..SomeServiceImpl.do*(..) )")
    public void process(JoinPoint point) {
        System.out.println("[MyAfterAspect] （最终通知） 目标方法的最后执行：记录完成时间 " + new Date());
    }
}
