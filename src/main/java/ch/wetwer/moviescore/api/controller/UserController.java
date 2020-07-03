package ch.wetwer.moviescore.api.controller;

import ch.wetwer.moviescore.api.data.access.UserDao;
import ch.wetwer.moviescore.api.data.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(path = "user", produces = "application/json")
    public User getUser(@RequestParam("id") String userId) {
        return userDao.getById(Long.valueOf(userId));
    }

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping(path = "users", produces = "application/json")
    public Iterable<User> getUserPages(@RequestParam(name = "pageNr", required = false, defaultValue = "1") String pageNr,
                                       @RequestParam(name = "search", required = false, defaultValue = "") String search,
                                       @RequestParam(name = "sort", required = false, defaultValue = "name") String sort) {
        return userDao.searchUsers(pageNr, search, sort);
    }


}
