package ch.wetwer.moviescore.api.data.repository;

import ch.wetwer.moviescore.api.data.entity.Comment;
import ch.wetwer.moviescore.api.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Wetwer
 * @project movie-score
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    void deleteCommentByUser(User user);

}
