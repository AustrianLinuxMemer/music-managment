package net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.put;

import net.htlgkr.fuerederl21025.musicmanagment.prepared.exceptions.ResponseStatusExceptions;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.Consumer;

public record MimePutDto(String mime) implements Consumer<ResponseStatusException> {
    @Override
    public void accept(ResponseStatusException e) {
        if (mime == null) throw e;
    }
}
