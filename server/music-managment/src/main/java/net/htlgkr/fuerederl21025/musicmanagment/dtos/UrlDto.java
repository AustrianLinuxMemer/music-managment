package net.htlgkr.fuerederl21025.musicmanagment.dtos;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Url;

public record UrlDto(int id, String url, int mime, int track) {
    public UrlDto(Url url) {
        this(url.getId(), url.getUrlTo(), url.getMime().getId(), url.getTrack().getId());
    }
}
