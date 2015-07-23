package de.crowdcode.speedauction.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration("DataSourceConfig")
@PropertySource(value="classpath:database.properties")
public class DataSourceConfig {

    @Value("${jdbcUrl}")
    private String jdbcUrl;
    @Value("${jdbcDriverClassName}")
    private String jdbcDriverClassName;
    @Value("${jdbcUsername}")
    private String jdbcUsername;
    @Value("${jdbcPassword}")
    private String jdbcPassword;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcDriverClassName);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        return dataSource;
    }

    @Bean
    // Attention: it must be static to be initialized very early in the process
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
