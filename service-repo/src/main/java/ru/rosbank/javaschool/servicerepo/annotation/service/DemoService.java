package ru.rosbank.javaschool.servicerepo.annotation.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosbank.javaschool.servicerepo.annotation.repository.DemoRepository;

@Service
@Getter
@RequiredArgsConstructor
public class DemoService {
  // if constructor is only one no @Autowired required
  private final DemoRepository repository;
}
