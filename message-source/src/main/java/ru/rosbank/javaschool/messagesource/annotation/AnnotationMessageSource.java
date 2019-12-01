package ru.rosbank.javaschool.messagesource.annotation;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component("messageSource")
public class AnnotationMessageSource implements MessageSource {

    private final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

    public AnnotationMessageSource() {
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
    }

    @Override
    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return messageSource.getMessage(code, args, defaultMessage, locale);
    }

    @Override
    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        return messageSource.getMessage(code, args, locale);
    }

    @Override
    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        return messageSource.getMessage(resolvable, locale);
    }
}