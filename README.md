# doubledatasource

###spring boot 添加双数据源实现添加和查询

###其中问题点： 数据原配置中spring boot2.0之后url 改成了jdbc-url不然会报错
###datasource:
  ####ds0:
    1.type: org.apache.commons.dbcp2.BasicDataSource
    2.driver-class-name: com.mysql.jdbc.Driver
    3.jdbc-url: jdbc:mysql://127.0.0.1:3306/ds0?allowMultiQueries=true&useUnicode=true&characterEncoding=utf8
    4.username: root
    5.password: root
  ds1:
    type: org.apache.commons.dbcp2.BasicDataSource
    driver-class-name: com.mysql.jdbc.Driver
    jdbc-url: jdbc:mysql://127.0.0.1:3306/ds1?allowMultiQueries=true&useUnicode=true&characterEncoding=utf8
    username: root
    password: root
