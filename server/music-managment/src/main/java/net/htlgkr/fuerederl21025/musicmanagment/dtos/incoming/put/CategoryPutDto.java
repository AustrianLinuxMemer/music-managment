package net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.put;

import net.htlgkr.fuerederl21025.musicmanagment.prepared.exceptions.ResponseStatusExceptions;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.RecordComponent;
import java.util.List;
import java.util.function.Consumer;

public record CategoryPutDto(String name, List<Integer> associatedTracks) implements Consumer<ResponseStatusException> {
    @Override
    public void accept(ResponseStatusException e) {
        if (name == null) throw e;
        if (associatedTracks == null) throw e;
    }
}
