package ch.wetwer.moviescore.api.data.repository;

import ch.wetwer.moviescore.api.data.entity.PreviewImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wetwer
 * @project movie-score
 * @package ch.wetwer.moviedbapi.data.previewimg
 * @created 09.04.2019
 **/

@Repository
public interface PreviewImageRepository extends JpaRepository<PreviewImage, Long> {
}
