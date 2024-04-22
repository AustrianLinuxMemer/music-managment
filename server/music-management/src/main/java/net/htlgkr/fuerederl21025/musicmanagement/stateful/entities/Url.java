package net.htlgkr.fuerederl21025.musicmanagement.stateful.entities;

import jakarta.persistence.*;

import java.util.Map;

@Entity
public class Url {
    @Id
    @GeneratedValue
    private int id;
    private String uriTo;
    @ManyToOne
    private Track track;
    @ElementCollection
    private Map<String, String> customMetadata;
    @ManyToOne
    private Mime mime;

    public Url() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUriTo() {
        return uriTo;
    }

    public void setUriTo(String uriTo) {
        this.uriTo = uriTo;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Map<String, String> getCustomMetadata() {
        return customMetadata;
    }

    public void setCustomMetadata(Map<String, String> customMetadata) {
        this.customMetadata = customMetadata;
    }

    public Mime getMime() {
        return mime;
    }

    public void setMime(Mime mime) {
        this.mime = mime;
    }
}
