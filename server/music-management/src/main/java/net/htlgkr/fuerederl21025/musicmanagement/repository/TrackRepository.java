package net.htlgkr.fuerederl21025.musicmanagement.repository;

import net.htlgkr.fuerederl21025.musicmanagement.entities.Track;
import org.springframework.data.repository.ListCrudRepository;

public interface TrackRepository extends ListCrudRepository<Track, Integer> {
}
