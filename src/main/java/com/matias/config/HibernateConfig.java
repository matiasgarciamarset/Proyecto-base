package com.matias.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class HibernateConfig {
	
	@Autowired
	private Environment env;
 
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    		LocalContainerEntityManagerFactoryBean sessionFactory = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    		sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.matias.model");
        sessionFactory.setJpaProperties(hibernateProperties());
        sessionFactory.setJpaVendorAdapter(vendorAdapter);
 
        return sessionFactory;
    }
 
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
 
        return dataSource;
    }
 
   @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
	   JpaTransactionManager transactionManager
       = new JpaTransactionManager();
     transactionManager.setEntityManagerFactory(
    		 entityManagerFactory().getObject() );
     return transactionManager;
    }
 
    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "connection.autoReconnect", env.getProperty("connection.autoReconnect"));
        hibernateProperties.setProperty(
                "hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        hibernateProperties.setProperty(
                "hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

        return hibernateProperties;
    }
}
