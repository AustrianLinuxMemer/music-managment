package net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.put;

import org.springframework.lang.NonNull;

public record UrlPutDto(@NonNull String url, @NonNull Integer mime, @NonNull Integer track) {
}
