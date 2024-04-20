package net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.post;

import net.htlgkr.fuerederl21025.musicmanagment.prepared.exceptions.ResponseStatusExceptions;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.function.Consumer;

public record CategoryPostDto(String name, List<Integer> associatedTracks) implements Consumer<ResponseStatusException> {
    @Override
    public void accept(ResponseStatusException e) {
        if (name == null) throw e;
    }
}
