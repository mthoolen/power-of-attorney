import nl.codesquad.specification.model.PowerOfAttorney
import nl.codesquad.specification.model.PowerOfAttorneyReference
import nl.codesquad.specification.model.Status.aCTIVE

class PowerOfAttorneyService(val repository: DataRepository) {

    fun findPOA(id: String): PowerOfAttorney? = repository.findPOA(id)
    fun findAllPOAReferences() = repository.findAllPOAS().map(::toReference)
    fun findDebitCard(id: String) = repository.findDebitCard(id).takeIf { it?.status == aCTIVE }
    fun findCreditCard(id: String) = repository.findCreditCard(id).takeIf { it?.status == aCTIVE }

    private fun toReference(powerOfAttorney: PowerOfAttorney) = PowerOfAttorneyReference(powerOfAttorney.id)

}