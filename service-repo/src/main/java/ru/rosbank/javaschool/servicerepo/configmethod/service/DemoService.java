package ru.rosbank.javaschool.servicerepo.configmethod.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.rosbank.javaschool.servicerepo.configmethod.repository.DemoRepository;


@Getter
@RequiredArgsConstructor
public class DemoService {
  private final DemoRepository repository;
}
