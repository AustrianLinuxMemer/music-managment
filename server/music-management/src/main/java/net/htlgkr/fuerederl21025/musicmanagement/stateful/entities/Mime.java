package net.htlgkr.fuerederl21025.musicmanagement.stateful.entities;

import jakarta.persistence.*;

@Entity
public class Mime {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne
    private Track track;

    public Mime() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
