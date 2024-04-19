package net.htlgkr.fuerederl21025.musicmanagment.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
public class Track {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true, nullable = false)
    private String name;
    @ManyToMany
    private List<Category> categories;
    @OneToMany
    private List<Url> Urls;
    @OneToOne
    private Url sourceUrl;
    private Map<String, String> trackUniqueMetadata;

    public Track() {
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        if (categories == null) return;
        this.categories = categories;
    }

    public List<Url> getURLs() {
        return Urls;
    }

    public void setURLs(List<Url> Urls) {
        if (Urls == null) return;
        this.Urls = Urls;
    }

    public Url getSourceURL() {
        return sourceUrl;
    }

    public void setSourceURL(Url sourceUrl) {
        if (sourceUrl == null) return;
        this.sourceUrl = sourceUrl;
    }

    public Map<String, String> getTrackUniqueMetadata() {
        return trackUniqueMetadata;
    }

    public void setTrackUniqueMetadata(Map<String, String> trackUniqueMetadata) {
        this.trackUniqueMetadata = trackUniqueMetadata;
    }
}
