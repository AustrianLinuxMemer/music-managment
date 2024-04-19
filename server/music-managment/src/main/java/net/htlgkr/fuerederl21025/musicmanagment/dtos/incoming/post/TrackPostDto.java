package net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.post;

import java.util.List;
import java.util.Map;

public record TrackPostDto(String name, List<Integer> associatedCategories, List<Integer> associatedUrls, Map<String, String> trackUniqueMetadata, Integer sourceUrl) {
}
