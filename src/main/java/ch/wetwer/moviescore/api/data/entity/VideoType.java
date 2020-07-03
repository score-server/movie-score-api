package ch.wetwer.moviescore.api.data.entity;

/**
 * @author Wetwer
 * @project movie-score
 * @package ch.wetwer.moviedbapi.data.uploadFile
 * @created 01.02.2019
 **/
public enum VideoType {

    MOVIE,
    EPISODE,
    UNDEFINED;

    public static VideoType getType(String type) {
        switch (type) {
            case "movie":
                return MOVIE;
            case "episode":
                return EPISODE;
            default:
                return UNDEFINED;
        }
    }
}
