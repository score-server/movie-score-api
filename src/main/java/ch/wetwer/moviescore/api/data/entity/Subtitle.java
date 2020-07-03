package ch.wetwer.moviescore.api.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Wetwer
 * @project movie-score
 * @package ch.wetwer.moviedbapi.data.entity
 * @created 26.11.2018
 **/

@Data
@Entity
public class Subtitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language;

    @Lob
    @JsonIgnore
    private byte[] file;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Episode episode;

    @ManyToOne
    private User user;

}
