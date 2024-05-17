package net.htlgkr.fuerederl21025.musicmanagement.real.entities;

import jakarta.persistence.*;
import net.htlgkr.fuerederl21025.musicmanagement.abstracts.entities.HasID;

import java.util.Map;
@Entity
public class URL implements HasID<Integer> {
    @Id
    @GeneratedValue
    private Integer id;
    private String url;
    private String mime;
    @ManyToOne
    private Track track;
    @ElementCollection
    private Map<String, String> metadata;
    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
