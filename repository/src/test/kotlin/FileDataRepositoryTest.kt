import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileDataRepositoryTest {

    private val repository = FileDataRepository()

    @Test
    internal fun `should load the POA entities from file`() {
        assertThat(repository.powerOfAttorneys.size).isEqualTo(4)
    }

    @Test
    internal fun `should load the account entities from file`() {
        assertThat(repository.accounts.size).isEqualTo(4)
    }
    @Test
    internal fun `should load the debit card entities from file`() {
        assertThat(repository.debitCards.size).isEqualTo(4)
    }
    @Test
    internal fun `should load the credit card entities from file`() {
        assertThat(repository.creditCards.size).isEqualTo(1)
    }
}