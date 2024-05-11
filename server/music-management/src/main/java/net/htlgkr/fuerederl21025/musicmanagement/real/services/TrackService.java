package net.htlgkr.fuerederl21025.musicmanagement.real.services;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.real.repositories.TrackRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

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
}
