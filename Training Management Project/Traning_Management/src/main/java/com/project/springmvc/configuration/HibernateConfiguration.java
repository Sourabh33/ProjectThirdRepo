package com.project.springmvc.configuration;

/* This class work for the configuration 
 * of hibernate
 */

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement/*  It is equivalent to Spring’s tx:
 							 * XML namespace, 
 							 * enabling Spring’s annotation-driven 
 							 * transaction management capability.
 							 */
@ComponentScan({"com.project.springmvc.configuration"})/*this will quivalent to 
														* context:component-scan base-package="..." in xml, 
														* providing with where to look for spring 
														* managed beans/classes.
														*/
@PropertySource(value = { "classpath:application.properties" })/* this is used to declare a set of 
																 * properties(defined in a properties file in application classpath)
 																 * in Spring run-time Environment, 
 																 * providing flexibility to have different values 
 																 * in different application environments.*/
public class HibernateConfiguration {
	
	@Autowired
	private Environment environment; /* Spring’s Environment to fetch the value 
									  * corresponding to an item
									  * From Application.properties 
	 								  */
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionfactory = new LocalSessionFactoryBean();
		sessionfactory.setDataSource(dataSource());
		sessionfactory.setPackagesToScan(new String[] {"com.project.springmvc.model"});
		sessionfactory.setHibernateProperties(hibernateProperties());
		return sessionfactory;
	}/* Method sessionFactory() is creating a  
	  * LocalSessionFactoryBean, 
	  * which exactly mirrors the XML based configuration
	  */

	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}
	/* Uses For Fetching Database 
	 * information using 
	 * environment variable */
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;
	}
	/* It is same as hibernate.properties */
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		 HibernateTransactionManager txManager = new HibernateTransactionManager();
		 txManager.setSessionFactory(s);
		 return txManager;
	}
	/* Once the SessionFactory is created, 
	 * it will be injected into Bean method 
	 * transactionManager which may eventually 
	 * provide transaction support for the 
	 * sessions created by this sessionFactory.
	 */
	
}
