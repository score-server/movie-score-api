package ch.wetwer.moviescore.api.data.repository;

import ch.wetwer.moviescore.api.data.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Wetwer
 * @project movie-score
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findBlogsByOrderByTimestampDesc();

    Blog findBlogById(Long id);
}
