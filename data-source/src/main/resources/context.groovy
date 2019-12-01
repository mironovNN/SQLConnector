import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.sqlite.SQLiteDataSource
import ru.rosbank.javaschool.datasource.groovy.GroovySqliteConnector

beans {
    propertyPlaceholderConfigurer PropertySourcesPlaceholderConfigurer, {
        location = 'classpath:db.properties'
    }

    sqLiteDataSource SQLiteDataSource, {
        url = 'java:/comp/env/jdbc/db'
    }

    connector GroovySqliteConnector, '${login}', '${password}', ref(sqLiteDataSource)
}