package ru.rosbank.javaschool.servicerepo.xml.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosbank.javaschool.servicerepo.xml.repository.DemoRepository;

@Service
@Getter
@RequiredArgsConstructor
public class DemoService {
  // if constructor is only one no @Autowired required
  private final DemoRepository repository;
}
