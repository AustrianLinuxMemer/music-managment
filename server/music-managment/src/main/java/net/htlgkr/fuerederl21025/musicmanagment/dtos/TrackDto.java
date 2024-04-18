package net.htlgkr.fuerederl21025.musicmanagment.dtos;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;

import java.util.List;

public record TrackDto(int id, List<URLDto> listOfAssociatedURLs, List<CategoryDto> listOfAssociatedCategories, URLDto source, String name) {
    public TrackDto(Track track) {
        this(track.getId(), track.getURLs().stream().map(URLDto::new).toList(), track.getCategories().stream().map(CategoryDto::new).toList(), new URLDto(track.getSourceURL()), track.getName());
    }
}
