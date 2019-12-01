import org.springframework.context.support.ReloadableResourceBundleMessageSource
import ru.rosbank.javaschool.messagesource.groovy.GroovyTranslator

beans {

    messageSource ReloadableResourceBundleMessageSource, {
        defaultEncoding = 'utf-8'
        basename = 'messages'
    }

    translator GroovyTranslator, ref(messageSource)
}