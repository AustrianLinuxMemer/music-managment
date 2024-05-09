package net.htlgkr.fuerederl21025.musicmanagement.entities;

import jakarta.persistence.*;

import java.util.Map;
import java.util.Set;
@Entity
public record Tag(
        @Id
        @GeneratedValue
        Integer id,
        @Column(unique = true, nullable = false)
        String name,
        @ManyToMany
        Set<Track> tracks,
        @ElementCollection
        Map<String, String> individualMetadata) {

}
