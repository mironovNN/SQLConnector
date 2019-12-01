package ru.rosbank.javaschool.placeholder.kotlin

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.context.support.beans
import org.springframework.core.io.ClassPathResource

val beans = beans {
    bean {
        PropertySourcesPlaceholderConfigurer().apply {
            setLocation(ClassPathResource("connection.properties"))
        }
    }
    bean<KotlinConnector>("connector")
}