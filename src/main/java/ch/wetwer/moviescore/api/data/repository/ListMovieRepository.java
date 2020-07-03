package ch.wetwer.moviescore.api.data.repository;

import ch.wetwer.moviescore.api.data.entity.ListMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wetwer
 * @project movie-score
 */
@Repository
public interface ListMovieRepository extends JpaRepository<ListMovie, Long> {

    ListMovie findListMovieById(Long id);

}
