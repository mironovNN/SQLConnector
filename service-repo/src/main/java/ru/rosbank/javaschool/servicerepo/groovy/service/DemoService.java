package ru.rosbank.javaschool.servicerepo.groovy.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.rosbank.javaschool.servicerepo.groovy.repository.DemoRepository;

@Getter
@RequiredArgsConstructor
public class DemoService {
    private final DemoRepository repository;
}