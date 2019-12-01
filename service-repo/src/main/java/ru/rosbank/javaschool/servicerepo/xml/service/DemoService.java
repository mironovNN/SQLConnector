package ru.rosbank.javaschool.servicerepo.xml.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosbank.javaschool.servicerepo.xml.repository.DemoRepository;

@Service
@Getter
@RequiredArgsConstructor
public class DemoService {
  private final DemoRepository repository;
}
