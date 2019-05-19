package controller

import entity.Movie
import service.MovieService

class MovieController(private val movieService: MovieService) {
    fun getMovie(movieId: Long): MovieResponse {
        return movieService.findById(movieId).toResponse()
    }
}

data class MovieResponse(var id: Long, var title: String, var onairStatus: Int)

private fun Movie.toResponse() = MovieResponse(id, title, onairStatus.rawValue)
