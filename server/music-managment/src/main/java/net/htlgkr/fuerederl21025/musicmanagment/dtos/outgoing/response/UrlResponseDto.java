package net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Url;

public record UrlResponseDto(Integer id, String url, Integer mime, Integer track) {
    public UrlResponseDto(Url url) {
        this(url.getId(), url.getUrlTo(), url.getMime().getId(), url.getTrack().getId());
    }
}
