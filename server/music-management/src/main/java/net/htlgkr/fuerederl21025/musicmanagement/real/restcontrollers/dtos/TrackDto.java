package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers.dtos;

import java.util.Map;
import java.util.Set;

public record TrackDto(Integer id, String name, Set<Integer> associatedUrls, Set<String> associatedTags, Map<String, String> metadata) {
}
