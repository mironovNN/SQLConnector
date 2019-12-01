package ru.rosbank.javaschool.placeholder.javaconfig;

import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class JavaConfiguration {
    @Bean // BFPP
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        val configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource("connection.properties"));
        return configurer;
    }

    @Bean // name -> method name
    public JavaConnector connector(@Value("${login}") String login, @Value("${password}") String password) {
        return new JavaConnector(login, password);
    }
}
