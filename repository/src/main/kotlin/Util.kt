import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue

internal val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule()).enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
internal inline fun <reified T> String.parse() = mapper.readValue<T>(this)