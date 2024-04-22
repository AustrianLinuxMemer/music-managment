package net.htlgkr.fuerederl21025.musicmanagement.stateful.entities;

import jakarta.persistence.*;

import java.util.Map;
import java.util.Set;
@Entity
public class Category {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToMany
    private Set<Track> tracks;
    @ElementCollection
    private Map<String, String> customMetadata;
    public Category() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getCustomMetadata() {
        return customMetadata;
    }

    public void setCustomMetadata(Map<String, String> customMetadata) {
        this.customMetadata = customMetadata;
    }
}
