package net.htlgkr.fuerederl21025.musicmanagment.entities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Entity
public class Track {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name;
    @ManyToMany
    private List<Category> categories;
    @OneToMany
    private List<Url> Urls;
    @OneToOne
    private Url sourceUrl;
    private String trackUniqueMetadataJSON;

    public Track() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return new Gson().fromJson(this.trackUniqueMetadataJSON, new TypeToken<Map<String, String>>() {}.getType());
    }

    public void setTrackUniqueMetadata(Map<String, String> trackUniqueMetadata) {
        this.trackUniqueMetadataJSON = new Gson().toJson(trackUniqueMetadata);
    }
}
