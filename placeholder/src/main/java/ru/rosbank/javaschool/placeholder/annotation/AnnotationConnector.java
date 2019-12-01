package ru.rosbank.javaschool.placeholder.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.rosbank.javaschool.placeholder.Connector;

@Component("connector")
public class AnnotationConnector implements Connector {
    private final String login;
    private final String password;

    public AnnotationConnector(@Value("${login}") String login, @Value("${password}") String password) {
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