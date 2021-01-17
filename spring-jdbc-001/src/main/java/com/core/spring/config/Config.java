package com.core.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = { "com.core.spring" })
public class Config {

	@Bean
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_db?serverTimezone=JST&useSSL=false");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("rootR00T");

		return dataSource;
	}

	@Bean
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DataSourceTransactionManager getDataSourceTransactionManager() {

		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(getDataSource());

		return transactionManager;
	}

	@Bean
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public JdbcTemplate getJdbcTemplate() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());

		return jdbcTemplate;
	}
}