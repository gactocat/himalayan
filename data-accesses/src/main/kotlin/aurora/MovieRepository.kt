package aurora

import entity.Movie
import entity.OnairStatus
import repository.IMovieRepository

class MovieRepository : IMovieRepository {
    override fun findById(movieId: Long): Movie? {
        return Movie(1, "Test", true, OnairStatus.IN_LIVE)
    }
}
