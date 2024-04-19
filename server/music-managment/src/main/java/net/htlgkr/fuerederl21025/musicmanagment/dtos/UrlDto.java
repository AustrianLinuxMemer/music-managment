package net.htlgkr.fuerederl21025.musicmanagment.dtos;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Url;

public record UrlDto(Integer id, String url, Integer mime, Integer track) {
    public UrlDto(Url url) {
        this(url.getId(), url.getUrlTo(), url.getMime().getId(), url.getTrack().getId());
    }
}
