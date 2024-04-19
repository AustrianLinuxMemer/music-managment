package net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;


import java.util.List;

public record CategoryResponseDto(Integer id, String name, List<Integer> associatedTracks){
    public CategoryResponseDto(Category category) {
        this(category.getId(), category.getName(), category.getTracks().stream().map(Track::getId).toList());
    }
}
