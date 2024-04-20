package net.htlgkr.fuerederl21025.musicmanagment.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response.MimeResponseDto;
import net.htlgkr.fuerederl21025.musicmanagment.prepared.errormessages.ErrorMessages;
import org.springframework.util.InvalidMimeTypeException;

@Entity
public class Mime {
    public static final String MIME_REGEX = "[^/+]+/[^/]*";
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true, nullable = false)
    private String mime;

    public Mime() {
    }
    public Mime(MimeResponseDto mimeResponseDto) {
        this.id = mimeResponseDto.id();
        this.mime = mimeResponseDto.mime();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMime() {
        return mime;
    }
    public void setMime(String mime) {
        if (!isValidMimeString(mime)) throw new InvalidMimeTypeException(mime, ErrorMessages.INVALID_MIME_MESSAGE.toString());
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
