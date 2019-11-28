package ru.rosbank.javaschool.servicerepo.configmethod;

import org.springframework.context.annotation.Bean;
import ru.rosbank.javaschool.servicerepo.configmethod.repository.DemoRepository;
import ru.rosbank.javaschool.servicerepo.configmethod.service.DemoService;

public class JavaConfig {
  @Bean
  public DemoRepository demoRepository() {
    return new DemoRepository();
  }

  @Bean
  public DemoService demoService() {
    return new DemoService(demoRepository());
  }
}
