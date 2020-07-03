package ch.wetwer.moviescore.api.data.repository;

import ch.wetwer.moviescore.api.data.entity.Genre;
import ch.wetwer.moviescore.api.data.entity.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Wetwer
 * @project movie-score
 */
@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {

    Movie findMovieById(Long id);

    Movie findMovieByTitle(String title);

    List<Movie> findMoviesByOrderByTitle();

    List<Movie> findMoviesByTitleContaining(String title, Pageable pageable);

    List<Movie> findMovieByTitleAndGenres(String title, Genre genre, Pageable pageable);
}

