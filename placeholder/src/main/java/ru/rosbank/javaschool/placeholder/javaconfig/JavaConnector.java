package ru.rosbank.javaschool.placeholder.javaconfig;

import ru.rosbank.javaschool.placeholder.Connector;

public class JavaConnector implements Connector {
    private final String login;
    private final String password;

    public JavaConnector(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Connector{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}