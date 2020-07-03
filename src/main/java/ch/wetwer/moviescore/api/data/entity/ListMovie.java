package ch.wetwer.moviescore.api.data.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Wetwer
 * @project movie-score
 */
@Data
@Entity
public class ListMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Timeline timeline;

    private Integer place;
}
