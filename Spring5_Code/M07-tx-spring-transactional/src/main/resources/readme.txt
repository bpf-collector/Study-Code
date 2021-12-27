描述：复制了 M06模块的代码，使用 Spring @Transactional 方法添加事务功能。

1. 在 Spring 配置文件中声明事务内容
    声明事务管理器
    声明开启事务的注解驱动
2. 在 public 的Service方法上添加 @Transactional 注解