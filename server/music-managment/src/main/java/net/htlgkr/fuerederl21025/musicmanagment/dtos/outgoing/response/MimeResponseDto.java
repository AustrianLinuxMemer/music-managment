package net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Mime;

public record MimeResponseDto(Integer id, String mime){
    public MimeResponseDto(Mime mime) {
        this(mime.getId(), mime.getMime());
    }
}
