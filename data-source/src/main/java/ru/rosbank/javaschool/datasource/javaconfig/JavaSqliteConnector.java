package ru.rosbank.javaschool.datasource.javaconfig;

import ru.rosbank.javaschool.datasource.SqliteConnector;

import javax.sql.DataSource;

public class JavaSqliteConnector implements SqliteConnector {
    private final String login;
    private final String password;
    private final DataSource sqLiteDataSource;

    public JavaSqliteConnector(String login, String password, DataSource sqLiteDataSource) {
        this.login = login;
        this.password = password;
        this.sqLiteDataSource = sqLiteDataSource;
    }

    @Override
    public String toString() {
        return "JavaSqliteConnector{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", sqLiteDataSource=" + sqLiteDataSource +
                '}';
    }
}
