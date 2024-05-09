package net.htlgkr.fuerederl21025.musicmanagement.real.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.Map;
import java.util.Set;
@Entity
public class Track extends BaseEntity<Integer> {
    @Id
    @GeneratedValue
    public Integer id;
    @Column(nullable = false)
    @NonNull
    public String name;
    @OneToMany(fetch = FetchType.EAGER)
    public Set<URL> urls;
    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Tag> tags;
    @ElementCollection(fetch = FetchType.EAGER)
    public Map<String, String> metadata;

    public Track(Integer id, @NonNull String name, Set<URL> urls, Set<Tag> tags, Map<String, String> metadata) {
        this.id = id;
        this.name = name;
        this.urls = urls;
        this.tags = tags;
        this.metadata = metadata;
    }

    public Track(@NonNull String name, Set<URL> urls, Set<Tag> tags, Map<String, String> metadata) {
        this.name = name;
        this.urls = urls;
        this.tags = tags;
        this.metadata = metadata;
    }

    public Track(){this.name = "";}
}
