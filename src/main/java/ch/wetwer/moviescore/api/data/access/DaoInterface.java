package ch.wetwer.moviescore.api.data.access;

import java.util.List;

/**
 * @author Wetwer
 * @project movie-score
 */

public interface DaoInterface<T> {

    T getById(Long id);

    List<T> getAll();

    void save(T t);

}
