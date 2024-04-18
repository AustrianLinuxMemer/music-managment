package net.htlgkr.fuerederl21025.musicmanagment.dtos;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;

import java.util.List;

public record CategoryDto(int id, String name, List<TrackDto> associatedTracks) {
    public CategoryDto(Category category) {
        this(category.getId(), category.getCategoryName(), category.getTracks().stream().map(TrackDto::new).toList());
    }
}
