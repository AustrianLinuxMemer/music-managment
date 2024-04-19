package net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.put;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Map;

public record TrackPutDto(@NonNull String name, @NonNull List<Integer> listOfAssociatedCategories, @NonNull List<Integer> listOfAssociatedURLs, @NonNull Map<String, String> trackUniqueMetadata, @NonNull Integer source) {
}
