package net.htlgkr.fuerederl21025.musicmanagment.dtos;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Mime;

public record MimeDto(int id, String mime){
    public MimeDto(Mime mime) {
        this(mime.getId(), mime.getMime());
    }
}
