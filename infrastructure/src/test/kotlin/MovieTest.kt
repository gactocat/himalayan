import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import controller.MovieResponse
import entity.OnairStatus
import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import io.ktor.util.KtorExperimentalAPI
import org.assertj.core.api.Assertions
import org.junit.Test
import org.koin.standalone.StandAloneContext

@KtorExperimentalLocationsAPI
@KtorExperimentalAPI
class MovieTest {
    val objectMapper = jacksonObjectMapper()

    @Test
    fun `Get a movie when request by id`() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "v1/movies/1")) {
                Assertions.assertThat(response.status()).isEqualTo(HttpStatusCode.OK)
                val movie = objectMapper.readValue(response.content, MovieResponse::class.java)
                Assertions.assertThat(movie).isEqualTo(MovieResponse(
                        1, "Test", OnairStatus.IN_LIVE.rawValue
                ))
            }
            StandAloneContext.stopKoin()
        }
    }
}