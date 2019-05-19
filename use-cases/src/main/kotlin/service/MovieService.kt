package service

import entity.Movie
import repository.IMovieRepository

interface MovieService {
    fun findById(userId: Long): Movie
}

class MovieServiceImpl(
        private val movieRepository: IMovieRepository
) : MovieService {
    override fun findById(userId: Long): Movie {
        return movieRepository.findById(userId) ?: throw IllegalStateException("No User Found for Given Id")
    }
}
