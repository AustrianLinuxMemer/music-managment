package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers.dto;

import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Track;

import java.util.Map;
import java.util.Set;

/**
 * Record symbolizing a {@link Track}
 * @param id The track's ID
 * @param name The track's name
 * @param urls The track's URLs
 * @param tags The track's tags
 * @param metadata The track's user-defined metadata
 */
public record TrackDto(Integer id, String name, Map<String, URLDto> urls, Set<String> tags, Map<String, String> metadata) {
    /**
     * Alternative Record so that instances of the Record can be generated in the case there is no ID or no need for an ID to
     * be supplied
     * @param name The track's name
     * @param urls The track's URLs
     * @param tags The track's tags
     * @param metadata The track's user-defined metadata
     */
    public TrackDto(String name, Map<String, URLDto> urls, Set<String> tags, Map<String, String> metadata) {
        this(null, name, urls, tags, metadata);
    }

    /**
     * Inner record symbolizing a {@link Track.URL}
     * @param url The URL
     * @param metadata The MIME type
     */
    public record URLDto(String url, String metadata) {
    }
}
