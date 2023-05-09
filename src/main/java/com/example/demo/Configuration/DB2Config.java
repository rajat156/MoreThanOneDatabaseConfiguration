package com.example.demo.Configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "db2entityManagerFactoryBean",
		basePackages = "com.example.demodb2.dao",
		transactionManagerRef = "db2transactionManager"
		)
public class DB2Config {
	@Primary
	@Bean(name="secondDataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@172.16.18.226:1521:NEODBSIT");
		dataSource.setUsername("TATA_DEV_PRD");
		dataSource.setPassword("Application$237363");
		return dataSource;
	}
	
	//34 min
	//Entity Manager Factory
	
	@Primary
	@Bean(name = "db2entityManagerFactoryBean")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		bean.setJpaVendorAdapter(adapter);
		bean.setPackagesToScan("com.example.demo.Entity");	
		return bean;
	}
	
	
	@Primary
	@Bean(name= "db2transactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		
		return manager;
	}
}
