package ru.rosbank.javaschool.datasource.groovy;

import lombok.Data;
import ru.rosbank.javaschool.datasource.SqliteConnector;

import javax.sql.DataSource;

@Data
public class GroovySqliteConnector implements SqliteConnector {
    private final String login;
    private final String password;
    private final DataSource sqLiteDataSource;

    public GroovySqliteConnector(String login, String password, DataSource sqLiteDataSource) {
        this.login = login;
        this.password = password;
        this.sqLiteDataSource = sqLiteDataSource;
    }

}
