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
    private String name;

    public Mime() {
    }
    public Mime(MimeResponseDto mimeResponseDto) {
        this.id = mimeResponseDto.id();
        this.name = mimeResponseDto.name();
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
        if (!isValidMimeString(name)) throw new InvalidMimeTypeException(name, ErrorMessages.INVALID_MIME_MESSAGE.toString());
        this.name = name;
    }

    public static boolean isValidMimeString(String string) {
        return string.matches(MIME_REGEX);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
