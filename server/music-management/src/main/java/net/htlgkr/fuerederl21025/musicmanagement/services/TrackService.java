package net.htlgkr.fuerederl21025.musicmanagement.services;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.repositories.TrackRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class TrackService extends AbstractCrudService<Track, Integer, TrackRepository> {
    @Override
    public Track update(@NonNull Track newItem, Integer integer) {
        return listCrudRepository.save(newItem);
    }
}
