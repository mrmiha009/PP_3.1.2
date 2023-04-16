package web.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:db.properties")
public class AppConfig {


   private Environment env;

   public AppConfig(Environment env) {
      this.env = env;
   }

   // beans

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
      final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(dataSource());
      em.setPackagesToScan(new String[] {"web.model"});

      final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);
      em.setJpaProperties(additionalProperties());


      return em;
   }

   @Bean
   public DataSource dataSource() {
      final DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
      dataSource.setUrl(env.getRequiredProperty("db.url"));
      dataSource.setUsername(env.getRequiredProperty("db.username"));
      dataSource.setPassword(env.getRequiredProperty("db.password"));

      return dataSource;
   }

   @Bean
   public PlatformTransactionManager transactionManager() {
      final JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
      return transactionManager;
   }

   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
      return new PersistenceExceptionTranslationPostProcessor();
   }

      Properties additionalProperties() {
      Properties properties = new Properties();
      properties.setProperty("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
      properties.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
      properties.setProperty("show_sql", env.getRequiredProperty("hibernate.show_sql"));

      return properties;
   }
//   final Properties additionalProperties() {
//      final Properties hibernateProperties = new Properties();
//      hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//      hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
//      hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", "false");
//
//      return hibernateProperties;
//   }
}

//package web.config;
//
//
////import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
////import org.springframework.orm.hibernate5.HibernateTransactionManager;
////import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
////import web.model.User;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//
//@Configuration
//@PropertySource("classpath:db.properties")
//@EnableTransactionManagement
////@ComponentScan(value = "web")
//public class AppConfig {
//
//   @Autowired
//   private Environment env;
//
//   @Bean
//   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//      LocalContainerEntityManagerFactoryBean em
//              = new LocalContainerEntityManagerFactoryBean();
//      em.setDataSource(dataSource());
//      em.setPackagesToScan(new String[] { "web.model"});
//
//      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//      em.setJpaVendorAdapter(vendorAdapter);
//      em.setJpaProperties(additionalProperties());
//      return em;
//   }
//   @Bean
//   public DataSource dataSource() {
//      DriverManagerDataSource dataSource = new DriverManagerDataSource();
//      dataSource.setDriverClassName("db.driver");
//      dataSource.setUrl("db.url");
//      dataSource.setUsername("db.username");
//      dataSource.setPassword("db.password");
//      return dataSource;
//   }
//
//   @Bean
//   public PlatformTransactionManager transactionManager() {
//      JpaTransactionManager transactionManager = new JpaTransactionManager();
//      transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//
//      return transactionManager;
//   }
//
//   @Bean
//   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
//      return new PersistenceExceptionTranslationPostProcessor();
//   }
//
//   Properties additionalProperties() {
//      Properties properties = new Properties();
//      properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//      properties.setProperty("show_sql", "true");
//
//      return properties;
//   }
//}
