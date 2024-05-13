package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers.dtos;

import java.util.Set;

public record URLDto(Integer id, String url, String mimetype, Set<Integer> associatedTracks) {
}
