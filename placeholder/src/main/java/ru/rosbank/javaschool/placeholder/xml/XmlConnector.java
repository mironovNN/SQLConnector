package ru.rosbank.javaschool.placeholder.xml;

import ru.rosbank.javaschool.placeholder.Connector;

public class XmlConnector implements Connector {
    private final String login;
    private final String password;

    public XmlConnector(String login, String password) {
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