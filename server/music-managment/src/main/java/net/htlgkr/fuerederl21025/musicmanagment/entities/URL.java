package net.htlgkr.fuerederl21025.musicmanagment.entities;

import jakarta.persistence.*;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.URLDto;

@Entity
public class URL {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private MIME mimetype;
    @ManyToOne
    private Track track;
    private String urlTo;

    public URL() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MIME getMimetype() {
        return mimetype;
    }

    public void setMimetype(MIME mimetype) {
        this.mimetype = mimetype;
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
        this.urlTo = urlTo;
    }
}
