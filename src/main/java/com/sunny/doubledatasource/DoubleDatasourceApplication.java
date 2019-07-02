package com.sunny.doubledatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
public class DoubleDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoubleDatasourceApplication.class, args);
    }

}
