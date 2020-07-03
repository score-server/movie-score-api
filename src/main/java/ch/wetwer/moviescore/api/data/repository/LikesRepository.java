package ch.wetwer.moviescore.api.data.repository;

import ch.wetwer.moviescore.api.data.entity.Likes;
import ch.wetwer.moviescore.api.data.entity.Movie;
import ch.wetwer.moviescore.api.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wetwer
 * @project movie-score
 */
@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {

    Likes findLikeByUserAndMovie(User user, Movie movie);

    void deleteLikesByUser(User user);

}
