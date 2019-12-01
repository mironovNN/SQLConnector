package ru.rosbank.javaschool.messagesource.javaconfig;

import lombok.val;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import ru.rosbank.javaschool.messagesource.Translator;

public class JavaConfiguration {
    @Bean
    public MessageSource messageSource() {
        val messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public Translator translator(MessageSource messageSource) {
        return new JavaTranslator(messageSource);
    }
}