import io.mockk.every
import io.mockk.mockk
import nl.codesquad.specification.model.CreditCard
import nl.codesquad.specification.model.DebitCard
import nl.codesquad.specification.model.PowerOfAttorney
import nl.codesquad.specification.model.Status.bLOCKED
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PowerOfAttorneyServiceTest {
    val repository: DataRepository = mockk()
    val service = PowerOfAttorneyService(repository)

    @Test
    internal fun `should be able to fetch a POA`() {
        every { repository.findAllPOAS() } returns listOf(PowerOfAttorney("1"))
        val allReferences = service.findAllPOAReferences()
        assertThat(allReferences.size).isEqualTo(1)
        assertThat(allReferences.first().id).isEqualTo("1")
    }

    @Test
    internal fun `should only return active credit cards`() {
        every { repository.findCreditCard("1") } returns CreditCard("1", bLOCKED)
        assertThat(service.findCreditCard("1")).isNull()
    }

    @Test
    internal fun `should only return active debit cards`() {
        every { repository.findDebitCard("1") } returns DebitCard("1", bLOCKED)
        assertThat(service.findDebitCard("1")).isNull()
    }


}