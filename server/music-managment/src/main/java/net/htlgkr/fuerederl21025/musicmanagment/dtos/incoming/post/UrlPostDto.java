package net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.post;

import org.springframework.web.server.ResponseStatusException;

import java.util.function.Consumer;

public record UrlPostDto(String url, Integer mime, Integer track) implements Consumer<ResponseStatusException> {
    @Override
    public void accept(ResponseStatusException e) {
        if (url == null) throw e;
    }
}
