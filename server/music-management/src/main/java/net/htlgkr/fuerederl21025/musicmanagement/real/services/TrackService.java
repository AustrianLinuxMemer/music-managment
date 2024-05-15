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

@Service
public class TrackService extends AbstractCrudService<Track, Integer, TrackRepository> {
    public List<Track> getAllTracksHavingSetThatContains(@NonNull Set<String> tags) {
        return listCrudRepository.findAllTracksHavingSetThatContains(tags);
    }
    public List<Track> getAllTracksWithKeyValuePair(@NonNull String key, String value) {
        return listCrudRepository.findAllTracksHavingKeyValuePair(key, value);
    }

    @Override
    public Track edit(Track item, Integer integer) {
        if (item == null || integer == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        Track oldTrack = getById(integer);
        oldTrack.name = item.name;
        oldTrack.urls = item.urls;
        oldTrack.metadata = item.metadata;
        oldTrack.tags = item.tags;
        return save(item);
    }
}
