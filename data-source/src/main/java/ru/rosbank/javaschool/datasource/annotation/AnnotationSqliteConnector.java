package ru.rosbank.javaschool.datasource.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.rosbank.javaschool.datasource.SqliteConnector;

import javax.sql.DataSource;

@Component("connector")
public class AnnotationSqliteConnector implements SqliteConnector {
    private final String login;
    private final String password;
    private final DataSource sqLiteDataSource;

    public AnnotationSqliteConnector(@Value("${login}") String login, @Value("${password}") String password, DataSource sqLiteDataSource) {
        this.login = login;
        this.password = password;
        this.sqLiteDataSource = sqLiteDataSource;
    }

    @Override
    public String toString() {
        return "AnnotationSqliteConnector{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", sqLiteDataSource=" + sqLiteDataSource +
                '}';
    }
}