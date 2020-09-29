package nl.codesquad.powerofattorney

import DataRepository
import FileDataRepository
import PowerOfAttorneyService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Beans {

    @Bean
    fun repository() = FileDataRepository()

    @Bean
    fun powerOfAttorneyService(dataRepository: DataRepository) = PowerOfAttorneyService(dataRepository)
}