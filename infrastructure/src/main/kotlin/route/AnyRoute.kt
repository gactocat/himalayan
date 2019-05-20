package route

import controller.MovieController
import io.ktor.application.call
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.route
import org.koin.ktor.ext.inject

@KtorExperimentalLocationsAPI
fun Routing.root() {
    val movieController: MovieController by inject()

    route("v1") {
        route("/movies") {
            get<MovieParam> { param ->
                call.respond(movieController.getMovie(param.movieId))
            }
        }
    }
}

@KtorExperimentalLocationsAPI
@Location("/{movieId}")
data class MovieParam(val movieId: Long)
