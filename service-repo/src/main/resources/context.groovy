import ru.rosbank.javaschool.servicerepo.groovy.repository.DemoRepository
import ru.rosbank.javaschool.servicerepo.groovy.service.DemoService

beans {

    demoRepository DemoRepository
    demoService DemoService, ref(demoRepository)

}