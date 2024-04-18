package net.htlgkr.fuerederl21025.musicmanagment.entities;

import jakarta.persistence.*;

import java.util.List;

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
    private List<URL> URLs;
    private URL sourceURL;

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
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<URL> getURLs() {
        return URLs;
    }

    public void setURLs(List<URL> URLs) {
        this.URLs = URLs;
    }

    public URL getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(URL sourceURL) {
        this.sourceURL = sourceURL;
    }
}
