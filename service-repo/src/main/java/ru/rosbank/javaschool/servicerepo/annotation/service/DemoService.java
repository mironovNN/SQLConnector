package ru.rosbank.javaschool.servicerepo.annotation.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosbank.javaschool.servicerepo.annotation.repository.DemoRepository;

@Service
@Getter
@RequiredArgsConstructor
public class DemoService {
  private final DemoRepository repository;
}
