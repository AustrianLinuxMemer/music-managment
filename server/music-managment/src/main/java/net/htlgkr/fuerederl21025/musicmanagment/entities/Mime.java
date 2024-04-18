package net.htlgkr.fuerederl21025.musicmanagment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.MimeDto;
import org.springframework.util.InvalidMimeTypeException;

@Entity
public class Mime {
    public static final String MIME_REGEX = "[^/+]+/[^/]*";
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true, nullable = false)
    private String mime;

    public Mime() {
    }
    public Mime(MimeDto mimeDto) {
        this.id = mimeDto.id();
        this.mime = mimeDto.mime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMime() {
        return mime;
    }
    public void setMime(String mime) {
        if (!isValidMimeString(mime)) throw new InvalidMimeTypeException(mime, "The provided Mulitpurpose Media Extension violates the Regex it's tested against: " + MIME_REGEX);
        this.mime = mime;
    }

    public static boolean isValidMimeString(String string) {
        return string.matches(MIME_REGEX);
    }

    @Override
    public String toString() {
        return this.getMime();
    }
}
