package com.bpf.before.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

/**
 * @Aspect 切面类的注解，用于标识当前类是切面类。
 *
 * 切面类内定义切面方法，并使用 通知注解（时间） 和 切入点表达式（位置） 进行标注。
 *
 * @Before 前置通知
 *  1) 方法定义规则
 *      public void 方法名(参数)
 *    其中，参数只能是 JoinPoint。
 *      JoinPoint 是连接点，即当前执行的方法，可以通过 JoinPoint 获取方法的执行信息，如参数、方法名等。
 *  2) 通知注解的使用
 *   属性：
 *     value 切入点表达式
 *   特点：在目标方法执行之前进行方法增强且不影响目标方法的执行。
 */
@Component
@Aspect
public class MyBeforeAspect {

    @Before("execution(public void com.bpf.before.service.impl.SomeServiceImpl.doSome(String) )")
    public void addExecTime() {
        System.out.println("[MyBeforeAspect] （前置通知） 当前执行时间：" + new Date());
    }

    @Before("execution(void do*(..))")
    public void noteExecMethod(JoinPoint point) {
        System.out.println("[MyBeforeAspect] （前置通知） 当前正在运行的方法是：");
        System.out.println("\tSign: " + point.getSignature());
        System.out.println("\tTarget: " + point.getTarget());
        System.out.println("\tKind: " + point.getKind());
        System.out.println("\tArgs: " + Arrays.toString(point.getArgs()));
    }
}
