package net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.post;

import java.util.List;

public record CategoryPostDto(String name, List<Integer> associatedCategories) {
}
