package net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Url;

import java.util.List;
import java.util.Map;

public record TrackResponseDto(Integer id, String name, List<Integer> listOfAssociatedCategories, List<Integer> listOfAssociatedURLs, Map<String, String> trackUniqueMetadata, Integer source) {
    public TrackResponseDto(Track track) {
        this(track.getId(), track.getName(), track.getCategories().stream().map(Category::getId).toList(), track.getURLs().stream().map(Url::getId).toList(), track.getTrackUniqueMetadata() ,track.getSourceURL().getId());
    }
}
