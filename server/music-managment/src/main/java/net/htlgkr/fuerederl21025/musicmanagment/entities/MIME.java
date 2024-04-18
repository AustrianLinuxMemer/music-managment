package net.htlgkr.fuerederl21025.musicmanagment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.apache.tika.Tika;

import java.io.File;
import java.io.IOException;

@Entity
public class MIME {
    public static final String MIME_REGEX = "[^\\/]+\\/?[^\\/+]+\\+?[^\\/+]+";
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true, nullable = false)
    private String mime;

    public MIME() {
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
        if (!isValidMimeString(mime)) return;
        this.mime = mime;
    }
    public static boolean isValidMimeString(String string) {
        return string.matches(MIME_REGEX);
    }
    public static MIME getMimeFromFileType(File file) throws IOException {
        MIME mime = new MIME();
        Tika tika = new Tika();
        mime.setMime(tika.detect(file));
        return mime;
    }

    @Override
    public String toString() {
        return this.getMime();
    }
}
