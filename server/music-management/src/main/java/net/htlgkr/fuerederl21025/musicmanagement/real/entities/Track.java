package net.htlgkr.fuerederl21025.musicmanagement.real.entities;

import jakarta.persistence.*;
import net.htlgkr.fuerederl21025.musicmanagement.abstracts.entities.HasID;

import java.util.Map;
import java.util.Set;

@Entity
public class Track implements HasID<Integer> {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToMany
    private Set<Tag> tags;
    @OneToMany
    private Set<URL> urls;
    @ElementCollection
    private Map<String, String> metadata;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<URL> getUrls() {
        return urls;
    }

    public void setUrls(Set<URL> urls) {
        this.urls = urls;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
