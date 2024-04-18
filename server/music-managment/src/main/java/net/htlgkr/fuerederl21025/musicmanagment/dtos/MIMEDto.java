package net.htlgkr.fuerederl21025.musicmanagment.dtos;

import net.htlgkr.fuerederl21025.musicmanagment.entities.MIME;

public record MIMEDto(int id, String mime) {
    public MIMEDto(MIME mime) {
        this(mime.getId(), mime.getMime());
    }
}
