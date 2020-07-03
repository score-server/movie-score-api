package ch.wetwer.moviescore.api.data.repository;

import ch.wetwer.moviescore.api.data.entity.ActivityLog;
import ch.wetwer.moviescore.api.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Wetwer
 * @project movie-score
 */

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {

    List<ActivityLog> findAllByOrderByTimestampDesc();

    List<ActivityLog> findActivityLogsByUserOrderByTimestampDesc(User user);

    void deleteActivityLogsByUser(User user);

}
