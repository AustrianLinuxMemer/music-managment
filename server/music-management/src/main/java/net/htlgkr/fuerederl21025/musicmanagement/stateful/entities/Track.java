package net.htlgkr.fuerederl21025.musicmanagement.stateful.entities;

import jakarta.persistence.*;

import java.util.Map;
import java.util.Set;
@Entity
public class Track {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToMany(mappedBy = "tracks")
    private Set<Category> categories;
    @OneToMany
    private Set<Url> urls;

    @ElementCollection
    private Map<String, String> customMetadata;
    public Track() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Url> getUrls() {
        return urls;
    }

    public void setUrls(Set<Url> urls) {
        this.urls = urls;
    }

    public Map<String, String> getCustomMetadata() {
        return customMetadata;
    }

    public void setCustomMetadata(Map<String, String> customMetadata) {
        this.customMetadata = customMetadata;
    }
}
