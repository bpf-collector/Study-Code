描述：使用 Spring 事务。

1. 使用 MySQL 数据库，创建商品表 Good, 销售表 Sale
2. 创建 maven 项目
3. 导入依赖
    spring-context, spring-jdbc, spring-tx,
    mybatis, mybatis-spring(用于Spring整合MyBatis)
    mysql驱动，druid(数据库连接池)
    junit

    注：当 MyBatis 整合 Spring 时，默认事务是自动提交的。
4. 创建实体类 Good Sale
5. 创建 DAO 接口 和 Mapper文件
6. MyBatis 配置文件
7. 创建 Service 接口和实现类
8. Spring 配置文件
    1) 声明数据源 DataSource, 用于连接数据库
    2) 声明 SqlSessionFactoryBean, 用于创建 SqlSessionFactory 对象
    3) 声明 MapperScannerConfigurer, 用于创建 DAO 的代理对象
    4) 声明 Service 对象，并注入 DAO
9. 测试方法测试