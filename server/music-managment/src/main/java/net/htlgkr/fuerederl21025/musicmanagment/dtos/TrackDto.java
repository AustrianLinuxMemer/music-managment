package net.htlgkr.fuerederl21025.musicmanagment.dtos;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Url;

import java.util.List;
import java.util.Map;

public record TrackDto(Integer id, List<Integer> listOfAssociatedURLs, List<Integer> listOfAssociatedCategories, Map<String, String> trackUniqueMetadata, UrlDto source, String name) {
    public TrackDto(Track track) {
        this(track.getId(), track.getURLs().stream().map(Url::getId).toList(), track.getCategories().stream().map(Category::getId).toList(), track.getTrackUniqueMetadata() ,new UrlDto(track.getSourceURL()), track.getName());
    }
}
