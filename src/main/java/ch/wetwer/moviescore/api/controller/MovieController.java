package ch.wetwer.moviescore.api.controller;

import ch.wetwer.moviescore.api.data.access.MovieDao;
import ch.wetwer.moviescore.api.data.entity.Movie;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private MovieDao movieDao;

    public MovieController(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(path = "movie", produces = "application/json")
    public Movie getMovie(@RequestParam("id") String movieId){
        return movieDao.getById(Long.valueOf(movieId));
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(path = "movies", produces = "application/json")
    public Iterable<Movie> getMoviesPage(@RequestParam(name = "pageNr", required = false, defaultValue = "1") String pageNr,
                                         @RequestParam(name = "search", required = false, defaultValue = "") String search,
                                         @RequestParam(name = "sort", required = false, defaultValue = "popularity") String sort,
                                         @RequestParam(name = "genre", required = false, defaultValue = "") String genre) {
        return movieDao.searchMovies(pageNr, search, sort, genre);
    }

}
