package ch.wetwer.moviescore.api.data.access;

import ch.wetwer.moviescore.api.config.ApplicationSettings;
import ch.wetwer.moviescore.api.data.entity.User;
import ch.wetwer.moviescore.api.data.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wetwer
 * @project movie-score
 */

@Service
public class UserDao implements DaoInterface<User> {

    private UserRepository userRepository;

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findUserById(id);
    }

    public Iterable<User> searchUsers(String pageNr, String search, String sort) {
        return userRepository.findUsersByNameContaining(search,
                PageRequest.of(Integer.parseInt(pageNr), ApplicationSettings.PAGE_SIZE, Sort.by(sort).ascending()));

    }
}
