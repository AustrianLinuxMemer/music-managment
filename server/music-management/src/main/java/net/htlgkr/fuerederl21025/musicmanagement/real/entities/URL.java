package net.htlgkr.fuerederl21025.musicmanagement.real.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.function.Predicate;
@Entity
public class URL extends BaseEntity<Integer> {
    public static final Predicate<String> isMime = (s) -> s.matches("[^/+]+/[^/]*");
    @Id
    @GeneratedValue
    public Integer id;
    @Column(nullable = false)
    @NonNull
    public String url;
    @Column(nullable = false)
    @NonNull
    public String mime;
    @ManyToOne(fetch = FetchType.EAGER)
    public Track track;

    public URL(Integer id, @NonNull String url, @NonNull String mime, Track track) {
        this.id = id;
        this.url = url;
        this.mime = mime;
        this.track = track;
    }

    public URL(@NonNull String url, @NonNull String mime, Track track) {
        this.url = url;
        this.mime = mime;
        this.track = track;
    }

    public URL() {
        this.url = "";
        this.mime = "";
    }
}
