package module

import aurora.MovieRepository
import controller.MovieController
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import repository.IMovieRepository
import service.MovieService
import service.MovieServiceImpl

object ModuleBuilder {
    fun modules(): List<Module> = listOf(module {
        // controllers
        single { MovieController(get()) }

        // services
        single<MovieService> { MovieServiceImpl(get()) }

        // repositories
        single<IMovieRepository> { MovieRepository() }
    })
}
