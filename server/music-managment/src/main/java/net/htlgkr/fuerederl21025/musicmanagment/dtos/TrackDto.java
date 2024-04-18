package net.htlgkr.fuerederl21025.musicmanagment.dtos;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Url;

import java.util.List;

public record TrackDto(int id, List<Integer> listOfAssociatedURLs, List<Integer> listOfAssociatedCategories, UrlDto source, String name) {
    public TrackDto(Track track) {
        this(track.getId(), track.getURLs().stream().map(Url::getId).toList(), track.getCategories().stream().map(Category::getId).toList(), new UrlDto(track.getSourceURL()), track.getName());
    }
}
