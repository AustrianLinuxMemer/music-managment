package net.htlgkr.fuerederl21025.musicmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.springframework.util.InvalidMimeTypeException;

import java.util.function.Predicate;

@Entity
public class URL {
    public static final Predicate<String> isMime = (s) -> s.matches("[^/+]+/[^/]*");
    @Id
    @GeneratedValue
    private int id;
    private String url;
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
