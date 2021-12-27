package com.bpf.afterthrowing.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Aspect 切面类的注解，用于标识当前类是切面类。
 *
 * 切面类内定义切面方法，并使用 通知注解（时间） 和 切入点表达式（位置） 进行标注。
 *
 * @AfterThrowing 异常通知
 *  1) 方法定义规则
 *      public void 方法名(Exception)
 *    参数：
 *      Exception 代表目标方法出现的异常
 *  2) 通知注解的使用
 *   属性：
 *     value        切入点表达式
 *     throwing    自定义的变量名，必须与形参名一致，用于表示目标方法的出现的异常对象
 *
 *   特点：
 *     在目标方法执行抛出异常后才执行，如果没有抛出异常则不执行。
 *     这种切面方法只能当作目标方法的监控程序，不能当作异常处理程序！
 *     当出现异常时，可以通过邮件、短信等方式通知开发人员。
 *
 *   执行流程类似于：
 *     try {
 *         SomeServiceImpl.do*(..)
 *     } catch(Exception e) {
 *         MyAfterThrowingAspect.process(e)
 *     }
 */
@Component
@Aspect
public class MyAfterThrowingAspect {

    @AfterThrowing(value = "execution(* *..SomeServiceImpl.do*(..) )",
            throwing = "ex")
    public void process(JoinPoint point, Exception ex) {
        System.out.println("[MyAfterThrowingAspect] （异常通知） 目标方法抛出异常时执行：");
        System.out.println("\t记录执行时间: " + new Date());
        System.out.println("\t记录异常信息：" + ex.getMessage());
        System.out.println("\t记录异常类型：" + ex.getClass());
    }
}
