package nl.codesquad.powerofattorney

import PowerOfAttorneyService
import nl.codesquad.specification.api.CreditCardsApiDelegate
import nl.codesquad.specification.api.DebitCardsApiDelegate
import nl.codesquad.specification.api.PowerOfAttorneysApiDelegate
import nl.codesquad.specification.model.CreditCard
import nl.codesquad.specification.model.DebitCard
import nl.codesquad.specification.model.PowerOfAttorney
import nl.codesquad.specification.model.PowerOfAttorneyReference
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@SpringBootApplication
@ComponentScan(basePackages = ["nl.codesquad"])
class PowerOfAttorneyApplication

fun main(args: Array<String>) {
    runApplication<PowerOfAttorneyApplication>(*args)
}

