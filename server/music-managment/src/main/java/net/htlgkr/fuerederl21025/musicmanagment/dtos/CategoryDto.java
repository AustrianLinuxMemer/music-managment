package net.htlgkr.fuerederl21025.musicmanagment.dtos;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;


import java.util.List;

public record CategoryDto(int id, String name, List<Integer> associatedTracks){
    public CategoryDto(Category category) {
        this(category.getId(), category.getName(), category.getTracks().stream().map(Track::getId).toList());
    }
}
