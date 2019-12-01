package ru.rosbank.javaschool.placeholder.kotlin;

import org.springframework.beans.factory.annotation.Value;
import ru.rosbank.javaschool.placeholder.Connector;

public class KotlinConnector implements Connector {
    private final String login;
    private final String password;

    public KotlinConnector(@Value("${login}") String login, @Value("${password}") String password) {
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