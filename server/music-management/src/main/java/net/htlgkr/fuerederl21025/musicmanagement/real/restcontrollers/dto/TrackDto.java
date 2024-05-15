package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers.dto;

import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Track;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Record symbolizing a {@link Track}
 * @param id The track's ID
 * @param name The track's name
 * @param urls The track's URLs
 * @param tags The track's tags
 * @param metadata The track's user-defined mime
 */
public record TrackDto(Integer id, String name, Map<String, URLDto> urls, Set<String> tags, Map<String, String> metadata) implements FromDto<Track> {
    /**
     * Alternative Record so that instances of the Record can be generated in the case there is no ID or no need for an ID to
     * be supplied
     * @param name The track's name
     * @param urls The track's URLs
     * @param tags The track's tags
     * @param metadata The track's user-defined mime
     */
    public TrackDto(String name, Map<String, URLDto> urls, Set<String> tags, Map<String, String> metadata) {
        this(null, name, urls, tags, metadata);
    }

    @Override
    public Track fromDtoWithoutID() {
        Track track = new Track();
        track.metadata = metadata;
        track.tags = tags;
        track.name = name;
        track.urls = urls.entrySet().stream().map(x -> Map.entry(x.getKey(), new URLDto(x.getValue().url, x.getValue().mime).fromDtoWithoutID())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return track;
    }

    @Override
    public Track fromDTOWithID() {
        Track track = new Track();
        track.id = id;
        track.metadata = metadata;
        track.tags = tags;
        track.name = name;
        track.urls = urls.entrySet().stream().map(x -> Map.entry(x.getKey(), new URLDto(x.getValue().url, x.getValue().mime).fromDtoWithoutID())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return track;
    }

    /**
     * Inner record symbolizing a {@link Track.URL}
     * @param url The URL
     * @param mime The MIME type
     */
    public record URLDto(String url, String mime) implements FromDto<Track.URL> {
        @Override
        public Track.URL fromDtoWithoutID() {
            Track.URL url = new Track.URL();
            url.url = this.url;
            url.mime = this.mime;
            return url;
        }

        @Override
        public Track.URL fromDTOWithID() {
            return fromDtoWithoutID();
        }
    }
}
