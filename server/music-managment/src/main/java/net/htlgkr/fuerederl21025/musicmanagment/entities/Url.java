package net.htlgkr.fuerederl21025.musicmanagment.entities;

import jakarta.persistence.*;

@Entity
public class Url {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Mime mime;
    @ManyToOne
    private Track track;
    @Column(nullable = false)
    private String urlTo;

    public Url() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mime getMime() {
        return mime;
    }

    public void setMime(Mime mime) {
        if (mime == null) return;
        this.mime = mime;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public String getUrlTo() {
        return urlTo;
    }

    public void setUrlTo(String urlTo) {
        if (urlTo == null) return;
        this.urlTo = urlTo;
    }
}
