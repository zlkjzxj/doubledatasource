package com.sunny.doubledatasource.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Description TODO
 * @Author sunny
 * @Date 2019-07-01 16:44
 */
@Configuration
@MapperScan(basePackages = {"com.sunny.doubledatasource.mapper.ds0"}, sqlSessionTemplateRef = "firstSqlSessionTemplate")

public class DataSourceDs0 {

    /**
     * 数据源
     *
     * @return dataSource
     */
    @Bean(name = "firstDataSource")
//    @Qualifier("firstDataSource")
    @Primary //必须加此注解
    @ConfigurationProperties(prefix = "datasource.ds0") // prefix值必须是application.properteis中对应属性的前缀
    public DataSource firstDataSource() {

        return DataSourceBuilder.create().build();

    }

    /**
     * SqlSessionFactory
     *
     * @param dataSource 数据源
     * @return SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory firstSqlSessionFactory(
            @Qualifier("firstDataSource") DataSource dataSource) throws Exception {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    /**
     * 事务管理器
     *
     * @param dataSource 数据源
     * @return 事务管理器
     */
    @Bean(name = "firstDataSourceTransactionManger")
    public DataSourceTransactionManager masterTransactionManger(
            @Qualifier("firstDataSource") DataSource dataSource) {

        return new DataSourceTransactionManager(dataSource);

    }

    /**
     * SqlSessionTemplate
     *
     * @param sqlSessionFactory sqlSessionFactory
     * @return SqlSessionTemplate
     */
    @Bean
    public SqlSessionTemplate firstSqlSessionTemplate(
            @Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {

        return new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory

    }
}
