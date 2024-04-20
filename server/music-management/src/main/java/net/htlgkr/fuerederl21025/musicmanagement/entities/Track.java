package net.htlgkr.fuerederl21025.musicmanagement.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
@Entity
public class Track {
    @Id
    @GeneratedValue
    private int id;
    @ManyToMany
    private Set<Category> categories;
    @OneToMany
    private Set<Url> urls;
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
}
