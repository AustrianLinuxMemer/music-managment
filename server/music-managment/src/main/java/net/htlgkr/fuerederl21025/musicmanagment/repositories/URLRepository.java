package net.htlgkr.fuerederl21025.musicmanagment.repositories;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Mime;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Url;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface URLRepository extends ListCrudRepository<Url, Integer> {
    List<Url> findByMime(Mime mime);
    List<Url> findByTrack(Track track);
    List<Url> findByTrackAndMime(Track track, Mime mime);
}
