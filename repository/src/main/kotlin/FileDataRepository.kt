import model.Account
import nl.codesquad.specification.model.CreditCard
import nl.codesquad.specification.model.DebitCard
import nl.codesquad.specification.model.PowerOfAttorney
import java.io.File

class FileDataRepository : DataRepository {
    internal val powerOfAttorneys: List<PowerOfAttorney> = loadFromDirectory("data/poa")
    internal val accounts: List<Account> = loadFromDirectory("data/accounts")
    internal val debitCards: List<DebitCard> = loadFromDirectory("data/debit-card")
    internal val creditCards: List<CreditCard> = loadFromDirectory("data/credit-card")

    override fun findPOA(id: String): PowerOfAttorney? = powerOfAttorneys.find { it.id == id }
    override fun findAllPOAS(): List<PowerOfAttorney> = powerOfAttorneys
    override fun findDebitCard(id: String): DebitCard? = debitCards.find { it.id == id }
    override fun findCreditCard(id: String): CreditCard? = creditCards.find { it.id == id }

    private inline fun <reified T> loadFromDirectory(directory: String): List<T> =
            javaClass.getResource(directory).file
                    .let(::File)
                    .walk()
                    .drop(1)
                    .map{it.readText()}
                    .map{it.parse<T>()}
                    .toList()
}