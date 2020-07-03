package ch.wetwer.moviescore.api.data.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author Wetwer
 * @project movie-score
 */
@Data
@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sessionId;

    @NotNull
    @ManyToOne
    private User user;

    private Timestamp timestamp;

    private boolean active;

}
