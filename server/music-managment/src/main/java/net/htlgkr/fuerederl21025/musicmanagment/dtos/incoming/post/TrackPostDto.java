package net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.post;

import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public record TrackPostDto(String name, List<Integer> associatedCategories, List<Integer> associatedUrls, Map<String, String> trackUniqueMetadata, Integer sourceUrl) implements Consumer<ResponseStatusException> {
    @Override
    public void accept(ResponseStatusException e) {
        if (name == null) throw e;
    }
}
