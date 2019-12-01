package ru.rosbank.javaschool.placeholder.programmatic;

import ru.rosbank.javaschool.placeholder.Connector;

public class ProgrammaticConnector implements Connector {
    private final String login;
    private final String password;

    public ProgrammaticConnector(String login, String password) {
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