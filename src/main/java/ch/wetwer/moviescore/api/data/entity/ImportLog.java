package ch.wetwer.moviescore.api.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Wetwer
 * @project movie-score
 */
@Data
@Entity
public class ImportLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String log;

    @ManyToOne
    private Movie movie;

    private String type;

    private Timestamp timestamp;
}
