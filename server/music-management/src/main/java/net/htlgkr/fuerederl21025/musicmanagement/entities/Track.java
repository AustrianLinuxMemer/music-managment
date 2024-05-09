package net.htlgkr.fuerederl21025.musicmanagement.entities;

import jakarta.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
public class Track {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    @OneToMany
    private Set<URL> urls;
    @ManyToMany
    private Set<Tag> tags;
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

    public Map<String, String> getIndividualMetadata() {
        return individualMetadata;
    }

    public void setIndividualMetadata(Map<String, String> individualMetadata) {
        this.individualMetadata = individualMetadata;
    }
}
