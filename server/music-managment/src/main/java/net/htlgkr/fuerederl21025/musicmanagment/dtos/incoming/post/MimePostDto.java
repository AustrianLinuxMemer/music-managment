package net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.post;

import org.springframework.web.server.ResponseStatusException;

import java.util.function.Consumer;

public record MimePostDto(String name) implements Consumer<ResponseStatusException> {
    @Override
    public void accept(ResponseStatusException e) {
        if (name == null) throw e;
    }
}
