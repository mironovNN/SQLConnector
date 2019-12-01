package ru.rosbank.javaschool.datasource.programmatic;

import ru.rosbank.javaschool.datasource.SqliteConnector;

import javax.sql.DataSource;

public class ProgrammaticSqliteConnector implements SqliteConnector {
    private final String login;
    private final String password;
    private final DataSource sqLiteDataSource;

    public ProgrammaticSqliteConnector(String login, String password, DataSource sqLiteDataSource) {
        this.login = login;
        this.password = password;
        this.sqLiteDataSource = sqLiteDataSource;
    }

    @Override
    public String toString() {
        return "ProgrammaticSqliteConnector{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", sqLiteDataSource=" + sqLiteDataSource +
                '}';
    }
}