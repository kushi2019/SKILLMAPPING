package com.niit;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.EmployeeDaoImpl;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.niit")
public class App {
	private final static String DATABASE_URL ="jdbc:mysql://localhost:3306/skillmapping";
	private final static String DATABASE_DRIVER ="com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT ="org.hibernate.dialect.MySQL5Dialect";
	private final static String DATABASE_USERNAME ="root";
	private final static String DATABASE_PASSWORD ="niit@321";
	
	
	@Bean("dataSource")
	public DataSource getDataSource()
	{
		BasicDataSource datasource =new BasicDataSource();
		
		// providing the database connection information
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);
		System.out.println("datasource created");
		return datasource;
		
	}
	// sessionFactory bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource)
	{
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(datasource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.niit");
		return builder.buildSessionFactory();
		
	}
	// All the hibernate properties will be returned in this method
	private Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		
		properties.put("hibernate.dailect",DATABASE_DIALECT);
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.format_sql","true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;

	}
	
	@Bean(name="employeeDAO")
	public EmployeeDaoImpl getEmployeeDao(SessionFactory sessionFactory)
	{
		return new EmployeeDaoImpl(sessionFactory);
	}
	
	//Transaction Manager Bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
		
		
	}

	
	
}
