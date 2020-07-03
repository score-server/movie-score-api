package ch.wetwer.moviescore.api.controller;

import ch.wetwer.moviescore.api.data.access.GenreDao;
import ch.wetwer.moviescore.api.data.entity.Genre;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {

    private GenreDao genreDao;


    public GenreController(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(value = "genre", produces = "application/json")
    public List<Genre> getGenres() {
        return genreDao.getAll();
    }

}
