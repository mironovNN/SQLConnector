package ru.rosbank.javaschool.messagesource.groovy;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import ru.rosbank.javaschool.messagesource.Translator;

import java.util.Locale;

@RequiredArgsConstructor
public class GroovyTranslator implements Translator {
    private final MessageSource messageSource;

    @Override
    public String translate(String code) {
        return messageSource.getMessage(code, null, Locale.getDefault());
    }
}