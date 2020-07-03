package ch.wetwer.moviescore.api.data.entity;

/**
 * @author Wetwer
 * @project movie-score
 * @package ch.wetwer.moviedbapi.data.user
 * @created 18.01.2019
 **/
public enum Role {

    ADMIN,
    USER;

    public static Role getRole(String role) {
        switch (role) {
            case "admin":
                return ADMIN;
            case "user":
                return USER;
            default:
                return null;
        }
    }
}
