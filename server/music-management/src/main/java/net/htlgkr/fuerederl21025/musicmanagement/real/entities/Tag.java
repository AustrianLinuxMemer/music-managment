package net.htlgkr.fuerederl21025.musicmanagement.real.entities;

import jakarta.persistence.*;

import java.util.Map;
import java.util.Set;
@Entity
public class Tag extends BaseEntity<String> {
    @Id
    public String id;
    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Track> tracks;
    @ElementCollection(fetch = FetchType.EAGER)
    public Map<String, String> metadata;

    public Tag(String id, Set<Track> tracks, Map<String, String> metadata) {
        this.id = id;
        this.metadata = metadata;
        this.tracks = tracks;
    }
    public Tag(){}
}
