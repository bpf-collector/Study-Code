package com.bpf.around.handler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Aspect 切面类的注解，用于标识当前类是切面类。
 *
 * 切面类内定义切面方法，并使用 通知注解（时间） 和 切入点表达式（位置） 进行标注。
 *
 * @Around 环绕通知
 *  1) 方法定义规则
 *      public Object 方法名(ProceedingJoinPoint, 其他参数)
 *    返回值类型：必须有，推荐使用 Object。代表目标方法的执行结果返回值。
 *    参数：
 *      ProceedingJoinPoint 是JoinPoint的子类，代表当前执行的方法，可以获取方法的执行信息，如参数、方法名等。
 *  2) 通知注解的使用
 *   属性：
 *     value        切入点表达式
 *
 *   特点：
 *     在目标方法执行之前或之后进行方法增强。
 *     可以根据需要修改方法的执行结果。
 */
@Component
@Aspect
public class MyAroundAspect {

    @Around(value = "execution(* *..SomeServiceImpl.do*(..) )")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        System.out.println("[MyAroundAspect] （环绕通知） 目标方法之前：记录执行时间 " + new Date());

        // 执行目标方法并拿到执行结果
        Object result = point.proceed();

        if (result instanceof String) {
            String res = (String) result;
            if (res.contains("doSome")) {
                result = res.replace("doSome", "something here");
            }
        }

        System.out.println("[MyAroundAspect] （环绕通知） 目标方法之后：执行事务功能");

        return result;
    }
}
