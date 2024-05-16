package net.htlgkr.fuerederl21025.musicmanagement.real.services;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.real.repositories.TrackRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
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
     * Delegates querying of tag to the {@link TrackRepository#findAllTracksHavingTag(String)}
     * @param tag Tags to search Tracks against
     * @return All tracks that match one or more tag
     * @see TrackRepository#findAllTracksHavingTag(String)
     */
    public List<Track> getAllTracksWithTag(@NonNull String tag) {
        return listCrudRepository.findAllTracksHavingTag(tag);
    }
    public List<Track> getAllTracksWithTags(@NonNull Set<String> tags) {
        return getAll().stream().filter(x -> tags.equals(x.tags)).toList();
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
