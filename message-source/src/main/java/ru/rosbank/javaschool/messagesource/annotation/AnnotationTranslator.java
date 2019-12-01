package ru.rosbank.javaschool.messagesource.annotation;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.rosbank.javaschool.messagesource.Translator;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class AnnotationTranslator implements Translator {
    private final MessageSource messageSource;

    @Override
    public String translate(String code) {
        return messageSource.getMessage(code, null, Locale.getDefault());
    }
}