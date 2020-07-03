package ch.wetwer.moviescore.api.data.repository;

import ch.wetwer.moviescore.api.data.entity.Movie;
import ch.wetwer.moviescore.api.data.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Wetwer
 * @project movie-score
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long Id);

    List<User> findUsersByNameContaining(String name, Pageable pageable);
}
