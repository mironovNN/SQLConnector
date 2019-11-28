package ru.rosbank.javaschool.servicerepo.configparam.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.rosbank.javaschool.servicerepo.configparam.repository.DemoRepository;


@Getter
@RequiredArgsConstructor
public class DemoService {
  // if constructor is only one no @Autowired required
  private final DemoRepository repository;
}
