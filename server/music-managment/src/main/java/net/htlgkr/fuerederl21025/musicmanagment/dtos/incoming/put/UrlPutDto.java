package net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.put;

import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.RecordComponent;
import java.util.function.Consumer;

public record UrlPutDto(String url, Integer mime, Integer track) implements Consumer<ResponseStatusException> {
    @Override
    public void accept(ResponseStatusException e) {
        if (url == null) throw e;
        if (mime == null) throw e;
        if (track == null) throw e;
    }
}
