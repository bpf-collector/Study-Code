package com.bpf.afterreturning.handler;

import com.bpf.afterreturning.bean.Person;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Aspect 切面类的注解，用于标识当前类是切面类。
 *
 * 切面类内定义切面方法，并使用 通知注解（时间） 和 切入点表达式（位置） 进行标注。
 *
 * @AfterReturning 后置通知
 *  1) 方法定义规则
 *      public void 方法名(参数)
 *    参数：
 *      JoinPoint 是连接点，即当前执行的方法，可以通过 JoinPoint 获取方法的执行信息，如参数、方法名等。
 *      Object(推荐) 表示目标方法的执行结果
 *  2) 通知注解的使用
 *   属性：
 *     value        切入点表达式
 *     returning    自定义的变量名，必须与形参名一致，用于表示目标方法的执行结果
 *
 *   特点：在目标方法执行之后进行方法增强且不影响目标方法的执行。
 *
 *   3) 方法的返回值
 *     当返回值类型为 基本数据类型及其包装类 或 String 时，返回值是不能修改的！
 *     当返回值类型为其他引用类型的 java对象时，对象的数据是可以修改的，如返回类型为 Person 时。
 */
@Component
@Aspect
public class MyAfterReturningAspect {

    @AfterReturning(value = "execution(* *..SomeServiceImpl.do*(..) )",
            returning = "res")
    public void process(JoinPoint point, Object res) {
        System.out.println("[MyAfterReturningAspect] （后置通知） 目标方法的执行结果是：" + res);

        // 当 返回值类型为 String 时，尝试修改，但修改失败。
        if (res instanceof String) {
            res += " < AfterReturning";
            System.out.println("[MyAfterReturningAspect] （后置通知） 修改方法返回值：string = " + res);
        }

        // 当 返回值类型为 其他引用类型的java对象时，可以修改成功。
        if (res instanceof Person) {
            Person person = (Person) res;
            person.setName("ZH-" + person.getName());
            System.out.println("[MyAfterReturningAspect] （后置通知） 修改方法返回值：person = " + person);
        }
    }
}
