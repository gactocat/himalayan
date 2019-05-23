package repository

import entity.Movie

interface IMovieRepository {
    fun findById(movieId: Long): Movie?
}
