package net.htlgkr.fuerederl21025.musicmanagement.entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Map;

@Entity
public class Track {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ElementCollection
    private List<String> tags;
    @ElementCollection
    private Map<String, String> individualMetadata;
    public Track(){}

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
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Map<String, String> getIndividualMetadata() {
        return individualMetadata;
    }

    public void setIndividualMetadata(Map<String, String> individualMetadata) {
        this.individualMetadata = individualMetadata;
    }
}
