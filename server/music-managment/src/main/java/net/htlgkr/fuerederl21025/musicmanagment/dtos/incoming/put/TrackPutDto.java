package net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.put;

import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.RecordComponent;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public record TrackPutDto(String name, List<Integer> listOfAssociatedCategories, List<Integer> listOfAssociatedURLs, Map<String, String> trackUniqueMetadata, Integer source) implements Consumer<ResponseStatusException> {
    @Override
    public void accept(ResponseStatusException e) {
        if (name == null) throw e;
        if (listOfAssociatedCategories == null) throw e;
        if (listOfAssociatedURLs == null) throw e;
        if (trackUniqueMetadata == null) throw e;
        if (source == null) throw e;
    }
}
