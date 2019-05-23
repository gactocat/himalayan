import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import controller.MovieResponse
import entity.OnairStatus
import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import org.assertj.core.api.Assertions
import org.junit.Test
import org.koin.standalone.StandAloneContext

class MovieTest {

    @Test
    fun 動画を1件取得する() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "v1/movies/111")) {
                HttpStatusCode.OK
                Assertions.assertThat(response.status()).isEqualTo(HttpStatusCode.OK)
                val movie = jacksonObjectMapper().readValue(response.content, MovieResponse::class.java)
                Assertions.assertThat(movie).isEqualTo(MovieResponse(
                        1, "Test", OnairStatus.IN_LIVE.rawValue
                ))
            }
            StandAloneContext.stopKoin()
        }
    }
}