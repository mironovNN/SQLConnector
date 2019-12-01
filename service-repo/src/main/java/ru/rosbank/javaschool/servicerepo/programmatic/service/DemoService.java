package ru.rosbank.javaschool.servicerepo.programmatic.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.rosbank.javaschool.servicerepo.programmatic.repository.DemoRepository;

@Getter
@RequiredArgsConstructor
public class DemoService {
    private final DemoRepository repository;
}