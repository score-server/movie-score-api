package ch.wetwer.moviescore.api.data.repository;

import ch.wetwer.moviescore.api.data.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Wetwer
 * @project movie-score
 * @package ch.wetwer.moviedbapi.data.announcement
 * @created 29.04.2019
 **/
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

}
