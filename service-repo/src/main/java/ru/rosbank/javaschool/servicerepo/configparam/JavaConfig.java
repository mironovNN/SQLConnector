package ru.rosbank.javaschool.servicerepo.configparam;

import org.springframework.context.annotation.Bean;
import ru.rosbank.javaschool.servicerepo.configparam.repository.DemoRepository;
import ru.rosbank.javaschool.servicerepo.configparam.service.DemoService;

public class JavaConfig {
  @Bean
  public DemoRepository demoRepository() {
    return new DemoRepository();
  }

  @Bean
  public DemoService demoService(DemoRepository repository) {
    return new DemoService(repository);
  }
}
