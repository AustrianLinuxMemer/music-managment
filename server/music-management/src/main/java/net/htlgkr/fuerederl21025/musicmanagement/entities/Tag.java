package net.htlgkr.fuerederl21025.musicmanagement.entities;

import jakarta.persistence.*;

import java.util.Map;
import java.util.Set;

@Entity
public class Tag {
    @Id
    @GeneratedValue
    private int id;
    @ManyToMany
    private Set<Track> tracks;
    @Column(unique = true, nullable = false)
    private String name;
    @ElementCollection
    private Map<String, String> individualMetadata;
    public Tag(){}

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

    public Map<String, String> getIndividualMetadata() {
        return individualMetadata;
    }

    public void setIndividualMetadata(Map<String, String> individualMetadata) {
        this.individualMetadata = individualMetadata;
    }
}
