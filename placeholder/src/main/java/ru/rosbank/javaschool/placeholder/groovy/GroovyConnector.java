package ru.rosbank.javaschool.placeholder.groovy;

import ru.rosbank.javaschool.placeholder.Connector;

public class GroovyConnector implements Connector {
    private final String login;
    private final String password;

    public GroovyConnector(String login, String password) {
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
