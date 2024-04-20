package net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;


import java.util.List;

public record CategoryResponseDto(Integer id, String name, List<Integer> associatedTracks){
    public static CategoryResponseDto generateNewCategoryResponseDto(Category category) {
        List<Integer> tracks;
        try {
            tracks = category.getTracks().stream().map(Track::getId).toList();
        } catch (NullPointerException e) {
            tracks = null;
        }
        return new CategoryResponseDto(category.getId(), category.getName(), tracks);
    }
}
