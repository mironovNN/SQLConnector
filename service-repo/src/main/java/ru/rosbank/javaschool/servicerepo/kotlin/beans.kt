package ru.rosbank.javaschool.servicerepo.kotlin

import org.springframework.context.support.beans
import ru.rosbank.javaschool.servicerepo.kotlin.repository.DemoRepository
import ru.rosbank.javaschool.servicerepo.kotlin.service.DemoService

val beans = beans {
    bean<DemoRepository>()

    bean {
        DemoService(ref())
    }
}