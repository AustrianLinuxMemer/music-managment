package net.htlgkr.fuerederl21025.musicmanagment.repositories;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.entities.URL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrackRepository extends ListCrudRepository<Track, Integer> {
    @Query("SELECT t FROM Track t WHERE e.name = :name")
    List<Track> findAllTracksNamed(@Param("name") String name);
    @Query("SELECT t FROM Track t WHERE :category MEMBER OF t.categories")
    List<Track> findAllTracksBelongingTo(@Param("category") Category category);
}
