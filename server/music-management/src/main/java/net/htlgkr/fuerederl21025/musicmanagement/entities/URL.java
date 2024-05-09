package net.htlgkr.fuerederl21025.musicmanagement.entities;

import jakarta.persistence.*;

import java.util.function.Predicate;

@Entity
public record URL(
        @Id
        @GeneratedValue
        Integer id,
        @Column(nullable = false)
        String url,
        @Column(nullable = false)
        String mimeType,
        @ManyToOne
        Track track) {
    public static final Predicate<String> isMime = (s) -> s.matches("[^/+]+/[^/]*");
}
