package ch.wetwer.moviescore.api.data.repository;

import ch.wetwer.moviescore.api.data.entity.GroupInvite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wetwer
 * @project movie-score
 */

@Repository
public interface GroupRepository extends JpaRepository<GroupInvite, Long> {

    GroupInvite findByNameEquals(String groupKey);

}
