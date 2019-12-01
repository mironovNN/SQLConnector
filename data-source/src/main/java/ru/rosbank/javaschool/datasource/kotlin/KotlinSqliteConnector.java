package ru.rosbank.javaschool.datasource.kotlin;

import org.springframework.beans.factory.annotation.Value;
import ru.rosbank.javaschool.datasource.SqliteConnector;

import javax.sql.DataSource;

public class KotlinSqliteConnector implements SqliteConnector {
    private final String login;
    private final String password;
    private final DataSource sqLiteDataSource;

    public KotlinSqliteConnector(@Value("${login}") String login, @Value("${password}") String password, DataSource sqLiteDataSource) {
        this.login = login;
        this.password = password;
        this.sqLiteDataSource = sqLiteDataSource;
    }

    @Override
    public String toString() {
        return "KotlinSqliteConnector{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", sqLiteDataSource=" + sqLiteDataSource +
                '}';
    }
}