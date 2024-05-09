package net.htlgkr.fuerederl21025.musicmanagement.entities;

import jakarta.persistence.*;
import org.springframework.util.InvalidMimeTypeException;

import java.util.function.Predicate;

@Entity
public class URL {
    public static final Predicate<String> isMime = (s) -> s.matches("[^/+]+/[^/]*");
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String mimeType;
    @ManyToOne
    private Track belongingTo;
    public URL(){}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        if (!isMime.test(mimeType)) throw new IllegalArgumentException("Given Mimetype " + mimeType + "failed `isMime` Regex");
        this.mimeType = mimeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Track getBelongingTo() {
        return belongingTo;
    }

    public void setBelongingTo(Track belongingTo) {
        this.belongingTo = belongingTo;
    }
}
