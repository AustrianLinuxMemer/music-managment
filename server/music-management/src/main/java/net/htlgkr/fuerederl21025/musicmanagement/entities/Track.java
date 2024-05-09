package net.htlgkr.fuerederl21025.musicmanagement.entities;

import jakarta.persistence.*;

import java.util.Map;
import java.util.Set;

@Entity
public record Track(
        @Id
        @GeneratedValue
        Integer id,
        @Column(nullable = false)
        String name,
        @OneToMany
        Set<URL> urls,
        @ManyToMany
        Set<Tag> tags,
        @ElementCollection
        Map<String, String> individualMetadata) {
}
