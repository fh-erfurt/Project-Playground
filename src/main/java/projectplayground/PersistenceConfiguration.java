package projectplayground;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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
public class PersistenceConfiguration {
@Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:projectplayground;DB_CLOSE_ON_EXIT=FALSE");
        dataSource.setUsername("");
        return dataSource();
    }
    @Bean
    public PlatformTransactionManager transactionManager(@Autowired LocalContainerEntityManagerFactoryBean entityManagerFactory){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
        return transactionManager;
    }
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Autowired DataSource dataSource){
        LocalContainerEntityManagerFactoryBean en = new LocalContainerEntityManagerFactoryBean();
        en.setDataSource(dataSource);
        en.setPackagesToScan(new String[]{"projectplayground.domains"});
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        en.setJpaVendorAdapter(vendorAdapter);
        en.setJpaProperties(additionalProperties());
        return en;
    }
    Properties additionalProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        return properties;
    }
}

