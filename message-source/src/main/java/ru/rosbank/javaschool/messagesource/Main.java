package ru.rosbank.javaschool.messagesource;

import lombok.val;
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.rosbank.javaschool.messagesource.javaconfig.JavaConfiguration;
import ru.rosbank.javaschool.messagesource.kotlin.BeansKt;
import ru.rosbank.javaschool.messagesource.programmatic.ProgrammaticTranslator;

public class Main {
    public static void main(String[] args) {
        {
            val context = new GenericApplicationContext();
            new XmlBeanDefinitionReader(context).loadBeanDefinitions("context.xml");
            context.refresh();
            Translator bean = context.getBean(Translator.class);
            System.out.println(bean.translate("welcome"));
        }

        {
            // messageSource -> reserved
            val context = new GenericApplicationContext();
            context.registerBean(ProgrammaticTranslator.class);
            context.registerBean("messageSource", MessageSource.class, () -> {
                val ms = new ReloadableResourceBundleMessageSource();
                ms.setBasename("messages");
                ms.setDefaultEncoding("UTF-8");
                return ms;
            });
            context.refresh();
            Translator bean = context.getBean(Translator.class);
            System.out.println(bean.translate("welcome"));
        }

        {
            val context = new AnnotationConfigApplicationContext("ru.rosbank.javaschool.messagesource.annotation");
            Translator bean = context.getBean(Translator.class);
            System.out.println(bean.translate("welcome"));
        }

        {
            val context = new GenericApplicationContext();
            val scanner = new ClassPathBeanDefinitionScanner(context);
            scanner.scan("ru.rosbank.javaschool.messagesource.annotation");
            context.refresh();
            Translator bean = context.getBean(Translator.class);
            System.out.println(bean.translate("welcome"));
        }

        {
            val context = new AnnotationConfigApplicationContext(JavaConfiguration.class);
            Translator bean = context.getBean(Translator.class);
            System.out.println(bean.translate("welcome"));
        }

        {
            val context = new GenericApplicationContext();
            val reader = new AnnotatedBeanDefinitionReader(context);
            reader.register(JavaConfiguration.class);
            context.refresh();
            Translator bean = context.getBean(Translator.class);
            System.out.println(bean.translate("welcome"));
        }

        {
            val context = new GenericGroovyApplicationContext("context.groovy");
            Translator bean = context.getBean(Translator.class);
            System.out.println(bean.translate("welcome"));
        }

        {
            val context = new GenericApplicationContext();
            val reader = new GroovyBeanDefinitionReader(context);
            reader.loadBeanDefinitions("context.groovy");
            context.refresh();
            Translator bean = context.getBean(Translator.class);
            System.out.println(bean.translate("welcome"));
        }

        {

            val context = new GenericApplicationContext();
            BeansKt.getBeans().initialize(context);
            context.refresh();
            Translator bean = context.getBean(Translator.class);
            System.out.println(bean.translate("welcome"));
        }
    }
}