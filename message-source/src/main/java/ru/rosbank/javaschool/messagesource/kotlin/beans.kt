package ru.rosbank.javaschool.messagesource.kotlin

import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.context.support.beans

val beans = beans {
    bean<KotlinTranslator>()
    bean("messageSource") {
        ReloadableResourceBundleMessageSource().apply {
            setDefaultEncoding("utf-8")
            setBasename("messages")
        }
    }
}