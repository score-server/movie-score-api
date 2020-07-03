package ch.wetwer.moviescore.api.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Wetwer
 * @project movie-score
 */
@Data
@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serie")
    private List<Season> seasons;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "serie")
    private List<Genre> genres;

    @Lob
    @Column
    private String descript;

    private String caseImg;
    private String backgroundImg;
    private Double popularity;
    private Double voteAverage;
    private Integer tmdbId;

}
