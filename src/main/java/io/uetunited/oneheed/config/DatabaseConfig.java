package io.uetunited.oneheed.config;

import org.jdbi.v3.core.Handles;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.SqlStatements;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

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
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setUser(dbUser);
        ds.setPassword(dbPass);
        ds.setUrl(dbUrl);
        return ds;
    }

    @Bean
    public Jdbi jdbi() {
        Jdbi jdbi = Jdbi.create(dataSource());
        jdbi.getConfig(SqlStatements.class).setUnusedBindingAllowed(true);
        jdbi.getConfig(Handles.class).setForceEndTransactions(true);

        jdbi.installPlugin(new PostgresPlugin());
        jdbi.installPlugin(new SqlObjectPlugin());
        return Jdbi.create(dataSource());
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}