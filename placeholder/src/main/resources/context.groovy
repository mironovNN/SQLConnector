import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import ru.rosbank.javaschool.placeholder.groovy.GroovyConnector

beans {
    propertyPlaceholderConfigurer PropertySourcesPlaceholderConfigurer, {
        location = 'classpath:connection.properties'
    }

    connector GroovyConnector, '${login}', '${password}'
}