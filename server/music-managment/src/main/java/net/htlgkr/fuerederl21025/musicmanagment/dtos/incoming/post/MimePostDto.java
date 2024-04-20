package net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.post;

import org.springframework.web.server.ResponseStatusException;

import java.util.function.Consumer;

public record MimePostDto(String mime) implements Consumer<ResponseStatusException> {
    @Override
    public void accept(ResponseStatusException e) {
        if (mime == null) throw e;
    }
}
