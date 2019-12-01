package ru.rosbank.javaschool.servicerepo.configparam.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.rosbank.javaschool.servicerepo.configparam.repository.DemoRepository;

@Getter
@RequiredArgsConstructor
public class DemoService {
  private final DemoRepository repository;
}
