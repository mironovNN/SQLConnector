package ru.rosbank.javaschool.placeholder;

import lombok.val;
import org.springframework.beans.factory.annotation.QualifierAnnotationAutowireCandidateResolver;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import ru.rosbank.javaschool.placeholder.kotlin.BeansKt;
import ru.rosbank.javaschool.placeholder.programmatic.ProgrammaticConnector;

public class Main {
    public static void main(String[] args) {
        {
            val context = new GenericApplicationContext();
            new XmlBeanDefinitionReader(context).loadBeanDefinitions("context.xml");
            context.refresh();
            System.out.println(context.getBean("connector"));
        }
        {
            val context = new AnnotationConfigApplicationContext("ru.rosbank.javaschool.placeholder.annotation");
            System.out.println(context.getBean("connector"));
        }
        {
            // @Configuration тоже обрабатывается AnnotationConfigApplicationContext'ом
            val context = new AnnotationConfigApplicationContext("ru.rosbank.javaschool.placeholder.java");
            System.out.println(context.getBean("connector"));
        }
        {
            val context = new GenericApplicationContext();
            context.registerBean(PropertySourcesPlaceholderConfigurer.class, () -> {
                val configurer = new PropertySourcesPlaceholderConfigurer();
                configurer.setLocation(new ClassPathResource("connection.properties"));
                return configurer;
            });
            context.registerBean("connector", ProgrammaticConnector.class, "${login}", "${password}");
            context.refresh();
            System.out.println(context.getBean("connector"));
        }
        {
            val context = new GenericGroovyApplicationContext("context.groovy");
            System.out.println(context.getBean("connector"));
        }
        {
            val factory = new DefaultListableBeanFactory();
            // т.к. в противном случае используется SimpleAutowireCandidateResolver, который не поддерживает аннотации
            factory.setAutowireCandidateResolver(new QualifierAnnotationAutowireCandidateResolver());
            val context = new GenericApplicationContext(factory);
            BeansKt.getBeans().initialize(context);
            context.refresh();
            System.out.println(context.getBean("connector"));
        }
    }
}