package ch.wetwer.moviescore.api.data.repository;

import ch.wetwer.moviescore.api.data.entity.Session;
import ch.wetwer.moviescore.api.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Wetwer
 * @project movie-score
 */

public interface SessionRepository extends JpaRepository<Session, Long> {

    Session findSessionBySessionIdAndActive(String sessionId, Boolean active);

    List<Session> findSessionsByUserAndActiveOrderByTimestamp(User user, Boolean active);

}
