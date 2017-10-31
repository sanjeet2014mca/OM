package com.online.market.main;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPDataSource;

/**
 * 
 * @author sanjeet
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = {
        "com.online.market"
})
@EnableTransactionManagement
public class PersistenceContext {

	private static final String[] PROPERTY_PACKAGES_TO_SCAN = {
		"com.online.market"
	};

	protected static final String PROPERTY_NAME_DATABASE_DRIVER ="spring.datasource.driverClassName";// "db.driver";
	protected static final String PROPERTY_NAME_DATABASE_PASSWORD = "spring.datasource.password";
	protected static final String PROPERTY_NAME_DATABASE_URL = "spring.datasource.url";
	protected static final String PROPERTY_NAME_DATABASE_USERNAME = "spring.datasource.username";

	
	
	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
//	private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	
//	private static final String HIBERNATE_CONNECTION_RELEASE_MODE	=	"hibernate.connection.release_mode";  
//	private static final String HIBERNATE_CONNECTION_AUTOCOMMIT	=	"hibernate.connection.autocommit";		
	
	private static final String HIBERNATE_C3P0_ACQUIRE_INCREMENT	=	"hibernate.c3p0.acquire_increment";
	private static final String HIBERNATE_C3P0_MINPOOLSIZE		=	"hibernate.c3p0.minPoolSize";
	private static final String HIBERNATE_C3P0_MAXPOOLSIZE		=	"hibernate.c3p0.maxPoolSize";
	private static final String HIBERNATE_C3P0_TIMEOUT		=	"hibernate.c3p0.timeout";
	private static final String HIBERNATE_C3P0_MAX_STATEMENT	=	"hibernate.c3p0.max_statement";
	private static final String HIBERNATE_C3P0_IDLE_TEST_PERIOD	=	"hibernate.c3p0.idle_test_period";     
	
	
	@Resource
	private Environment env;

	@Bean
	public DataSource dataSource() {
		BoneCPDataSource dataSource = new BoneCPDataSource();

		dataSource.setDriverClass(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setJdbcUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

		return dataSource;
	}

	  @Bean
	    public JpaTransactionManager transactionManager() {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();

	        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

	        return transactionManager;
	    }

	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

	        entityManagerFactoryBean.setDataSource(dataSource());
	        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	        entityManagerFactoryBean.setPackagesToScan(PROPERTY_PACKAGES_TO_SCAN);

	        Properties jpaProperties = new Properties();
	        jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
	        jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
	        jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
//	        jpaProperties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
	        jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
	        
//	        jpaProperties.put(HIBERNATE_CONNECTION_RELEASE_MODE, env.getRequiredProperty(HIBERNATE_CONNECTION_RELEASE_MODE));
//	        jpaProperties.put(HIBERNATE_CONNECTION_AUTOCOMMIT, env.getRequiredProperty(HIBERNATE_CONNECTION_AUTOCOMMIT));
	        jpaProperties.put(HIBERNATE_C3P0_ACQUIRE_INCREMENT, env.getRequiredProperty(HIBERNATE_C3P0_ACQUIRE_INCREMENT));
	        jpaProperties.put(HIBERNATE_C3P0_IDLE_TEST_PERIOD, env.getRequiredProperty(HIBERNATE_C3P0_IDLE_TEST_PERIOD));
	        jpaProperties.put(HIBERNATE_C3P0_MAX_STATEMENT, env.getRequiredProperty(HIBERNATE_C3P0_MAX_STATEMENT));
	        jpaProperties.put(HIBERNATE_C3P0_MAXPOOLSIZE, env.getRequiredProperty(HIBERNATE_C3P0_MAXPOOLSIZE));
	        jpaProperties.put(HIBERNATE_C3P0_MINPOOLSIZE, env.getRequiredProperty(HIBERNATE_C3P0_MINPOOLSIZE));
	        jpaProperties.put(HIBERNATE_C3P0_TIMEOUT, env.getRequiredProperty(HIBERNATE_C3P0_TIMEOUT));

	        entityManagerFactoryBean.setJpaProperties(jpaProperties);

	        return entityManagerFactoryBean;
	    }
}
