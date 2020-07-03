package ch.wetwer.moviescore.api.data.access;

import ch.wetwer.moviescore.api.config.ApplicationSettings;
import ch.wetwer.moviescore.api.data.entity.Movie;
import ch.wetwer.moviescore.api.data.repository.MovieRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wetwer
 * @project movie-score
 */

@Service
public class MovieDao implements DaoInterface<Movie> {

    private MovieRepository movieRepository;

    public MovieDao(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie getById(Long id) {
        return movieRepository.findMovieById(id);
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findMoviesByOrderByTitle();
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public Iterable<Movie> searchMovies(String pageNr, String search, String sort, String genre) {
        return movieRepository.findMoviesByTitleContaining(search,
                PageRequest.of(Integer.parseInt(pageNr), ApplicationSettings.PAGE_SIZE, Sort.by(sort).descending()));
    }

}
