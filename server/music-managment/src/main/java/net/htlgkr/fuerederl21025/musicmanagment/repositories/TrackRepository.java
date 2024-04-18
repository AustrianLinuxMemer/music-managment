package net.htlgkr.fuerederl21025.musicmanagment.repositories;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TrackRepository extends ListCrudRepository<Track, Integer> {
    List<Track> findByNameLike(String name);
    List<Track> findByCategories(Category category);
}
