package ru.rosbank.javaschool.datasource;

import lombok.val;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.sqlite.SQLiteDataSource;
import ru.rosbank.javaschool.datasource.javaconfig.JavaConfiguration;
import ru.rosbank.javaschool.datasource.kotlin.BeansKt;
import ru.rosbank.javaschool.datasource.programmatic.ProgrammaticSqliteConnector;

public class Main {
    public static void main(String[] args) {
        {
            val context = new GenericApplicationContext();
            new XmlBeanDefinitionReader(context).loadBeanDefinitions("context.xml");
            context.refresh();
            System.out.println(context.getBean("connector"));
        }
        {
            val context = new AnnotationConfigApplicationContext("ru.rosbank.javaschool.datasource.annotation");
            System.out.println(context.getBean("connector"));
        }
        {
            val context = new AnnotationConfigApplicationContext(JavaConfiguration.class);
            System.out.println(context.getBean("connector"));

        }
        {
            val context = new GenericApplicationContext();
            context.registerBean(PropertySourcesPlaceholderConfigurer.class, () -> {
                val configurer = new PropertySourcesPlaceholderConfigurer();
                configurer.setLocation(new ClassPathResource("db.properties"));
                return configurer;
            });
            context.registerBean("datasource", SQLiteDataSource.class, () -> {
                val dataSource = new SQLiteDataSource();
                dataSource.setUrl("java:/comp/env/jdbc/db");
                return dataSource;
            });
            context.refresh();
            context.registerBean("connector", ProgrammaticSqliteConnector.class, "${login}", "${password}", context.getBean("datasource"));
            System.out.println(context.getBean("connector"));
        }
        {
            val context = new GenericApplicationContext();
            val reader = new GroovyBeanDefinitionReader(context);
            reader.loadBeanDefinitions("context.groovy");
            context.refresh();
            System.out.println(context.getBean("connector"));
        }
        {
            val factory = new DefaultListableBeanFactory();
            factory.setAutowireCandidateResolver(new QualifierAnnotationAutowireCandidateResolver());
            val context = new GenericApplicationContext(factory);
            BeansKt.getBeans().initialize(context);
            context.refresh();
            System.out.println(context.getBean("connector"));
        }
    }

}
