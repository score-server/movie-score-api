package ch.wetwer.moviescore.api.data.repository;

import ch.wetwer.moviescore.api.data.entity.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Wetwer
 * @project movie-score
 * @package ch.wetwer.moviedbapi.data.uploadFile
 * @created 16.01.2019
 **/
public interface UploadFileRepository extends JpaRepository<UploadFile, Long> {

    UploadFile findByHash(int hash);

    List<UploadFile> findAllByOrderByVideoTypeDescFilenameAsc();

}
