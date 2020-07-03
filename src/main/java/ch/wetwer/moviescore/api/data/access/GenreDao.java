package ch.wetwer.moviescore.api.data.access;

import ch.wetwer.moviescore.api.data.entity.Genre;
import ch.wetwer.moviescore.api.data.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wetwer
 * @project movie-score
 */

@Service
public class GenreDao implements DaoInterface<Genre> {

    private GenreRepository genreRepository;

    public GenreDao(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre getById(Long id) {
        return genreRepository.getOne(id);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findGenreByOrderByName();
    }

    @Override
    public void save(Genre genre) {
        genreRepository.save(genre);
    }

    public List<Genre> getForMovies() {
        return genreRepository.findGenresByMovieNotNullOrderByName();
    }

    public List<Genre> getForSeries() {
        return genreRepository.findGenresBySerieNotNullOrderByName();
    }
}
