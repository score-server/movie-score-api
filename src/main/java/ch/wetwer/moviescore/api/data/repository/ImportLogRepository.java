package ch.wetwer.moviescore.api.data.repository;

import ch.wetwer.moviescore.api.data.entity.ImportLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Wetwer
 * @project movie-score
 */
@Repository
public interface ImportLogRepository extends JpaRepository<ImportLog, Long> {

    List<ImportLog> findAllByOrderByTimestampDesc();

}
