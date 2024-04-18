package net.htlgkr.fuerederl21025.musicmanagment.dtos;

import net.htlgkr.fuerederl21025.musicmanagment.entities.URL;

public record URLDto(int id, String url, String mimetype) {
    public URLDto(URL url) {
        this(url.getId(), url.getUrlTo(), url.getMimetype().toString());
    }
}
