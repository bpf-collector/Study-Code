描述：使用 Spring Web 模拟注册学生。

1. 使用 MySQL 数据库，使用学生表 Student
    id int primary key auto_increment,
    name varchar(80),
    age int
2. 创建 maven 项目
3. 导入依赖
    spring-context, spring-jdbc, spring-tx,
    mybatis, mybatis-spring(用于Spring整合MyBatis)
    mysql驱动，druid(数据库连接池)
    junit
    jsp-api, javax.servlet-api

4. 创建实体类 Student
5. 创建 DAO 接口 和 Mapper文件
6. MyBatis 配置文件
7. 创建 Service 接口和实现类
8. 修改 index.jsp
9. 创建 Servlet，接收请求参数，处理请求
10.web.xml 配置 Servlet
11. Spring 配置文件
    1) 声明数据源 DataSource, 用于连接数据库
    2) 声明 SqlSessionFactoryBean, 用于创建 SqlSessionFactory 对象
    3) 声明 MapperScannerConfigurer, 用于创建 DAO 的代理对象
    4) 声明 Service 对象，并注入 DAO
12. 测试方法测试

>>> 存在问题：

在 Servlet 中，获取 ApplicationContext 容器对象都是创建出来的，
这表示每有一个请求就会创建新的容器对象，这不仅耗时，而且浪费内存。

26-Dec-2021 15:48:06.790 信息 [http-nio-8080-exec-4] com.alibaba.druid.support.logging.JakartaCommonsLoggingImpl.info {dataSource-2} inited
ctx = org.springframework.context.support.ClassPathXmlApplicationContext@340804ae, started on Sun Dec 26 15:48:06 CST 2021
26-Dec-2021 15:48:12.408 信息 [http-nio-8080-exec-5] com.alibaba.druid.support.logging.JakartaCommonsLoggingImpl.info {dataSource-3} inited
ctx = org.springframework.context.support.ClassPathXmlApplicationContext@4db4beb9, started on Sun Dec 26 15:48:12 CST 2021
26-Dec-2021 15:48:15.947 信息 [http-nio-8080-exec-6] com.alibaba.druid.support.logging.JakartaCommonsLoggingImpl.info {dataSource-4} inited
ctx = org.springframework.context.support.ClassPathXmlApplicationContext@2f50dd69, started on Sun Dec 26 15:48:15 CST 2021
26-Dec-2021 15:48:19.515 信息 [http-nio-8080-exec-7] com.alibaba.druid.support.logging.JakartaCommonsLoggingImpl.info {dataSource-5} inited
ctx = org.springframework.context.support.ClassPathXmlApplicationContext@5569d141, started on Sun Dec 26 15:48:19 CST 2021

>>> 问题解决：

  怎么才能只让 容器对象 只创建一次，而且相互共享使用呢？ 《监听器》
    Spring 提供了监听器 ServletContextListener 可以创建容器对象，并将对象放入 ServletContext 全局共享作用域中。
    ServletContextListener 接口的一个实现类: ContextLoaderListener。可以在 web.xml 中进行配置使用，同时指定 Spring 配置文件路径。

ctx = Root WebApplicationContext, started on Sun Dec 26 15:49:28 CST 2021
ctx = Root WebApplicationContext, started on Sun Dec 26 15:49:28 CST 2021
ctx = Root WebApplicationContext, started on Sun Dec 26 15:49:28 CST 2021
ctx = Root WebApplicationContext, started on Sun Dec 26 15:49:28 CST 2021