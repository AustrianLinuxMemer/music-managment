package net.htlgkr.fuerederl21025.musicmanagement.real.entities;

import jakarta.persistence.*;
import net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers.dto.ToDto;
import net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers.dto.TrackDto;
import org.springframework.lang.NonNull;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * This is the Track entity, it is (and also should be) the only Entity stored in the JPA due to the authors inability
 * to properly manage entity relationships, this improves project simplicity at the cost of normalization
 * This hibernation strategy should be seen as a temporary solution, although the author doubts that this temporary
 * solution will ever be changed
 *
 * @author Leo Füreder
 * @version C.D.
 */
@Entity
public class Track extends BaseEntity<Integer> implements ToDto<TrackDto> {
    /**
     * ID for JPA to do it's persistence magic
     */
    @Id
    @GeneratedValue
    public Integer id;
    /**
     * This is the name of the track
     */
    @Column(nullable = false)
    @NonNull
    public String name;
    /**
     * This represents the various URLs this Track references, the key of this map is a simple CSV line of Tag strings
     * The obtaining of the right URL out of the map is the responsibility of the client
     * <br/><br/>
     * Example:
     * <code>tag1,tag2,tag3,tag4</code>
     */
    @ElementCollection(fetch = FetchType.EAGER)
    public Map<String, URL> urls;
    @ElementCollection(fetch = FetchType.EAGER)
    public Set<String> tags;
    /**
     * This represents user-defined mime for each Track object, the mime needs to be handled by the client, the
     * server only provides queries that lets you search these key-value pairs server-side
     */
    @ElementCollection(fetch = FetchType.EAGER)
    public Map<String, String> metadata;
    public Track(){this.name = "";}

    @Override
    public TrackDto toDtoWithoutID() {
        Map<String, TrackDto.URLDto> map = urls.entrySet().stream().map(x -> Map.entry(x.getKey(), x.getValue().toDtoWithoutID())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return new TrackDto(name, map, tags, metadata);
    }

    @Override
    public TrackDto toDtoWithID() {
        Map<String, TrackDto.URLDto> map = urls.entrySet().stream().map(x -> Map.entry(x.getKey(), x.getValue().toDtoWithoutID())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return new TrackDto(id, name, map, tags, metadata);
    }


    /**
     * Inner class to aid the storage of URLs of Tracks
     *
     * @author Leo Füreder
     * @version C.D.
     */
    @Embeddable
    public static class URL implements ToDto<TrackDto.URLDto> {
        /**
         * The URL string
         */
        public String url;
        /**
         * The mimetype
         */
        public String mime;

        @Override
        public TrackDto.URLDto toDtoWithoutID() {
            return new TrackDto.URLDto(url, mime);
        }

        @Override
        public TrackDto.URLDto toDtoWithID() {
            return toDtoWithoutID();
        }
    }
}


