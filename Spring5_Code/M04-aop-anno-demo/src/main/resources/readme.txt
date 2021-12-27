描述：使用 AspectJ 框架注解版，实现切面增强功能。

1. 创建 maven 项目
2. 导入依赖
    spring-context
    spring-aspects
    junit
3. 创建业务接口及实现类
4. 创建切面类
  1) 类上使用 @Aspect 注解
  2) 类中定义切面增强方法
5. 创建配置文件
  1) 开启注解扫描
  2) 开启自动代理生成器
6. 测试方法测试