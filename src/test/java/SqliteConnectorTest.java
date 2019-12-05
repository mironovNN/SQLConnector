import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.sqlite.SQLiteDataSource;
import ru.rosbank.javaschool.datasource.annotation.AnnotationSqliteConnector;
import ru.rosbank.javaschool.datasource.annotation.AnnotationSqliteDataSource;
import ru.rosbank.javaschool.datasource.groovy.GroovySqliteConnector;
import ru.rosbank.javaschool.datasource.javaconfig.JavaConfiguration;
import ru.rosbank.javaschool.datasource.javaconfig.JavaSqliteConnector;
import ru.rosbank.javaschool.datasource.kotlin.BeansKt;
import ru.rosbank.javaschool.datasource.kotlin.KotlinSqliteConnector;
import ru.rosbank.javaschool.datasource.programmatic.ProgrammaticSqliteConnector;
import ru.rosbank.javaschool.datasource.xml.XmlSqliteConnector;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SqliteConnectorTest {

    @Test
    public void annotation(){
        val context = new AnnotationConfigApplicationContext("ru.rosbank.javaschool.datasource.annotation");
        AnnotationSqliteConnector result = (AnnotationSqliteConnector)context.getBean("connector");
        AnnotationSqliteDataSource sqliteDataSource = (AnnotationSqliteDataSource)context.getBean("datasource");
        assertEquals("login", result.getLogin());
        assertEquals("password", result.getPassword());
        assertEquals("java:/comp/env/jdbc/db", sqliteDataSource.getUrl());
    }

    @Test
    public void groovy(){
        val context = new GenericApplicationContext();
        val reader = new GroovyBeanDefinitionReader(context);
        reader.loadBeanDefinitions("context.groovy");
        context.refresh();
        GroovySqliteConnector result = (GroovySqliteConnector)context.getBean("connector");
        assertEquals("login", result.getLogin());
        assertEquals("password", result.getPassword());

    }

    @Test
    public void javaconfig(){
        val context = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        JavaSqliteConnector result = (JavaSqliteConnector)context.getBean("connector");
        assertEquals("login", result.getLogin());
        assertEquals("password", result.getPassword());
    }

    @Test
    public void kotlin(){
        val factory = new DefaultListableBeanFactory();
        factory.setAutowireCandidateResolver(new QualifierAnnotationAutowireCandidateResolver());
        val context = new GenericApplicationContext(factory);
        BeansKt.getBeans().initialize(context);
        context.refresh();
        KotlinSqliteConnector result = (KotlinSqliteConnector)context.getBean("connector");
        assertEquals("login", result.getLogin());
        assertEquals("password", result.getPassword());
    }

    @Test
    public void programmatic(){
        val context = new GenericApplicationContext();
        context.registerBean(PropertySourcesPlaceholderConfigurer.class, () -> {
            val configurer = new PropertySourcesPlaceholderConfigurer();
            configurer.setLocation(new ClassPathResource("db.properties"));
            return configurer;
        });
        context.registerBean("datasource", SQLiteDataSource.class, bd -> {
            bd.getPropertyValues().addPropertyValue("url", "${db_url}");
        });
        context.registerBean("connector",
                ProgrammaticSqliteConnector.class,
                "${login}", "${password}", new RuntimeBeanReference("datasource"));
        context.refresh();
        ProgrammaticSqliteConnector result = (ProgrammaticSqliteConnector)context.getBean("connector");
        assertEquals("login", result.getLogin());
        assertEquals("password", result.getPassword());
    }

    @Test
     public void xml(){
        val context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("context.xml");
        context.refresh();
        XmlSqliteConnector result = (XmlSqliteConnector)context.getBean("connector");
        assertEquals("login", result.getLogin());
        assertEquals("password", result.getPassword());
    }
}
