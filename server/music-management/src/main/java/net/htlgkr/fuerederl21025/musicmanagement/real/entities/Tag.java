package net.htlgkr.fuerederl21025.musicmanagement.real.entities;

import jakarta.persistence.*;
import net.htlgkr.fuerederl21025.musicmanagement.abstracts.entities.HasID;

import java.util.Set;
import java.util.Map;
@Entity
public class Tag implements HasID<String> {
    @Id
    private String id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tag> subTags;
    @ManyToOne
    private Tag superTag;
    @ManyToMany(mappedBy = "tags")
    private Set<Track> tracks;
    @ElementCollection
    private Map<String, String> metadata;
    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public Set<Tag> getSubTags() {
        return subTags;
    }

    public void setSubTags(Set<Tag> subTags) {
        this.subTags = subTags;
    }

    public Tag getSuperTag() {
        return superTag;
    }

    public void setSuperTag(Tag superTag) {
        this.superTag = superTag;
    }

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
