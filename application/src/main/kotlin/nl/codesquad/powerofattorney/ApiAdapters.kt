package nl.codesquad.powerofattorney

import PowerOfAttorneyService
import nl.codesquad.specification.api.CreditCardsApiDelegate
import nl.codesquad.specification.api.DebitCardsApiDelegate
import nl.codesquad.specification.api.PowerOfAttorneysApiDelegate
import nl.codesquad.specification.model.DebitCard
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CreditCardsAdapter(private val poaService: PowerOfAttorneyService) : CreditCardsApiDelegate {
    override fun getCreditCardDetail(id: String) = poaService.findCreditCard(id).toResponse()
}

@Service
class DebitCardsAdapter(private val poaService: PowerOfAttorneyService) : DebitCardsApiDelegate {
    override fun getDebitCardDetail(id: String): ResponseEntity<DebitCard> = poaService.findDebitCard(id).toResponse()
}

@Service
class PowerOfAttorneyAdapter(private val poaService: PowerOfAttorneyService) : PowerOfAttorneysApiDelegate {
    override fun getAllPowerOfAttorneys() = poaService.findAllPOAReferences().toResponse()

    override fun getPowerOfAttorneyDetail(id: String) = poaService.findPOA(id).toResponse()
}

private inline fun <reified T> T?.toResponse(): ResponseEntity<T> = if (this == null) ResponseEntity.notFound().build() else ResponseEntity.ok(this)
