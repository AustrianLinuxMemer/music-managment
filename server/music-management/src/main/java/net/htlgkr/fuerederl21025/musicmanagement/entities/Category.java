package net.htlgkr.fuerederl21025.musicmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
@Entity
public class Category {
    @Id
    @GeneratedValue
    private int id;
    @ManyToMany(mappedBy = "categories")
    private Set<Track> track;
    public Category() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Track> getTrack() {
        return track;
    }

    public void setTrack(Set<Track> track) {
        this.track = track;
    }
}
