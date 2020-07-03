package ch.wetwer.moviescore.api.data.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Wetwer
 * @project movie-score
 */
@Data
@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column
    @NotNull
    private String request;

    @NotNull
    private String active;

    @NotNull
    @ManyToOne
    private User user;


}
