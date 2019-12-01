package ru.rosbank.javaschool.datasource.xml;

import org.sqlite.SQLiteDataSource;
import ru.rosbank.javaschool.datasource.SqliteConnector;

import javax.sql.DataSource;

public class XmlSqliteConnector implements SqliteConnector {
    private final String login;
    private final String password;
    private final DataSource sqLiteDataSource;

    public XmlSqliteConnector(String login, String password, DataSource sqLiteDataSource) {
        this.login = login;
        this.password = password;
        this.sqLiteDataSource = sqLiteDataSource;
    }

    @Override
    public String toString() {
        return "XmlSqliteConnector{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", sqLiteDataSource=" + sqLiteDataSource +
                '}';
    }
}