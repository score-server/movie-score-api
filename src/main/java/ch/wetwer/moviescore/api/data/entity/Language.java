package ch.wetwer.moviescore.api.data.entity;

/**
 * @author Wetwer
 * @project movie-score
 * @package ch.wetwer.moviedbapi.data.entity
 * @created 26.11.2018
 **/
public enum Language {

    GERMAN("DE"),
    ENGLISH("EN");


    private String language;

    Language(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
