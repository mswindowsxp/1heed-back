package io.uetunited.oneheed.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.sql2o.GenericDatasource;
import org.sql2o.Sql2o;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig implements TransactionManagementConfigurer {

    @Value("${spring.datasource.url}")
    String dbUrl;

    @Value("${spring.datasource.username}")
    String dbUser;

    @Value("${spring.datasource.password}")
    String dbPass;


    @Bean
    public DataSource dataSource() {
        DataSource ds = new GenericDatasource(dbUrl, dbUser, dbPass);
        return ds;
    }

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public Sql2o sql2o() {
        return new Sql2o(dataSource());
    }

}