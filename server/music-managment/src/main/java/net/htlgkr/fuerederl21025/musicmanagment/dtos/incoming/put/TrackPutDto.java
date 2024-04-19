package net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.put;
import java.util.List;
import java.util.Map;

public record TrackPutDto(String name, List<Integer> listOfAssociatedCategories, List<Integer> listOfAssociatedURLs, Map<String, String> trackUniqueMetadata, Integer source) {
}
