package service

import entity.Movie
import repository.IMovieRepository

interface MovieService {
    fun findById(movieId: Long): Movie
}

class MovieServiceImpl(
        private val movieRepository: IMovieRepository
) : MovieService {
    override fun findById(movieId: Long): Movie {
        return movieRepository.findById(movieId) ?: throw IllegalStateException("No User Found for Given Id")
    }
}
