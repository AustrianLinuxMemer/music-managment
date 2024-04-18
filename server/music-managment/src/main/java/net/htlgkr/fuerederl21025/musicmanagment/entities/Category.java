package net.htlgkr.fuerederl21025.musicmanagment.entities;

import jakarta.persistence.*;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.CategoryDto;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true, nullable = false)
    private String name;
    @ManyToMany
    private List<Track> tracks;

    public Category() {
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
        if (name == null) return;
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        if (tracks == null) return;
        this.tracks = tracks;
    }
}
