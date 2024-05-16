package net.htlgkr.fuerederl21025.musicmanagement.real.services;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.real.repositories.TrackRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;


/**
 * Service class implementing {@link Track}-specific queries while extending {@link AbstractCrudService} to receive basic
 * CRUD operations
 *
 * @author Leo Füreder
 * @version C.D.
 * @see AbstractCrudService
 */
@Service
public class TrackService extends AbstractCrudService<Track, Integer, TrackRepository> {
    /**
     * Delegates querying of tags to the {@link TrackRepository#findAllTracksHavingSetThatContains(Set tags)}
     * @param tags Tags to search Tracks against
     * @return All tracks that match one or more tags
     * @see TrackRepository#findAllTracksHavingSetThatContains(Set tags)
     */
    public List<Track> getAllTracksHavingSetThatContains(@NonNull Set<String> tags) {
        return listCrudRepository.findAllTracksHavingSetThatContains(tags);
    }

    /**
     * Delegates querying of key-value pairs to the {@link TrackRepository#findAllTracksHavingKeyValuePair(String key, String value)}
     * @param key The key to query for
     * @param value The value to query for
     * @return All Tracks containing the key and the value queried for
     */
    public List<Track> getAllTracksWithKeyValuePair(@NonNull String key, String value) {
        return listCrudRepository.findAllTracksHavingKeyValuePair(key, value);
    }

    @Override
    public Track replace(@NonNull Track item, @NonNull Integer integer) {
        if (item == null || integer == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        Track oldTrack = getById(integer);
        oldTrack.name = item.name;
        oldTrack.urls = item.urls;
        oldTrack.metadata = item.metadata;
        oldTrack.tags = item.tags;
        return save(item);
    }
}
