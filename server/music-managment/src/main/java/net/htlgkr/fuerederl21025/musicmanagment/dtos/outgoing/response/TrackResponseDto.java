package net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Url;

import java.util.List;
import java.util.Map;

public record TrackResponseDto(Integer id, String name, List<Integer> listOfAssociatedCategories, List<Integer> listOfAssociatedURLs, Map<String, String> trackUniqueMetadata, Integer source) {
    public static TrackResponseDto generateNewTrackResponseDto(Track track) {
        List<Integer> categories;
        List<Integer> urls;
        try {
            categories = track.getCategories().stream().map(Category::getId).toList();
        } catch (NullPointerException e) {
            categories = null;
        }
        try {
            urls = track.getURLs().stream().map(Url::getId).toList();
        } catch (NullPointerException e) {
            urls = null;
        }
        return new TrackResponseDto(track.getId(), track.getName(), categories, urls, track.getTrackUniqueMetadata(), track.getSourceURL().getId());
    }
}
