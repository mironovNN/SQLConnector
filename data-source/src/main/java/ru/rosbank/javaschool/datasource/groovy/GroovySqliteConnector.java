package ru.rosbank.javaschool.datasource.groovy;

import javax.sql.DataSource;

public class GroovySqliteConnector {
    private final String login;
    private final String password;
    private final DataSource sqLiteDataSource;

    public GroovySqliteConnector(String login, String password, DataSource sqLiteDataSource) {
        this.login = login;
        this.password = password;
        this.sqLiteDataSource = sqLiteDataSource;
    }

    @Override
    public String toString() {
        return "GroovySqliteConnector{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", sqLiteDataSource=" + sqLiteDataSource +
                '}';
    }
}
