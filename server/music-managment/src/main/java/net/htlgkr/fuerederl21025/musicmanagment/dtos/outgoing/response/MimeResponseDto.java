package net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Mime;

public record MimeResponseDto(Integer id, String mime){
    public static MimeResponseDto generateMimeResponseDto(Mime mime) {
        return new MimeResponseDto(mime.getId(), mime.getMime());
    }
}
