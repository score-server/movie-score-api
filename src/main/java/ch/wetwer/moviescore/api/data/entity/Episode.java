package ch.wetwer.moviescore.api.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Wetwer
 * @project movie-score
 */
@Data
@Entity
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Season season;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "episode")
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "episode")
    private List<Time> times;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "episode")
    private List<Subtitle> subtitles;

    private String path;
    private String quality;
    private Integer episode;
    private Integer convertPercentage;

    public String getMime() {
        if (path.endsWith(".mkv")) {
            return "video/x-matroska";
        } else if (path.endsWith(".mp4")) {
            return "video/mp4";
        } else if (path.endsWith(".avi")) {
            return "video/x-msvideo";
        } else {
            return "";
        }
    }

    public boolean canConvert() {
        return path.endsWith(".mkv") || path.endsWith(".avi");
    }

    public String getFullTitle() {
        return season.getSerie().getTitle() + " S" + season.getSeason() + "E" + getEpisode();
    }
}
