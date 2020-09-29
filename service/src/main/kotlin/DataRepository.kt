import nl.codesquad.specification.model.CreditCard
import nl.codesquad.specification.model.DebitCard
import nl.codesquad.specification.model.PowerOfAttorney

interface DataRepository {
    fun findPOA(id: String): PowerOfAttorney?
    fun findAllPOAS(): List<PowerOfAttorney>
    fun findDebitCard(id: String): DebitCard?
    fun findCreditCard(id: String): CreditCard?
}