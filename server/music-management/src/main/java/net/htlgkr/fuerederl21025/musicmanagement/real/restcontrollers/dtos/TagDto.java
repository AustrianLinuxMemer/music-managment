package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers.dtos;

import java.util.Map;
import java.util.Set;

public record TagDto(String id, Set<Integer> associatedTracks, Map<String, String> metadata) {
}
