package net.htlgkr.fuerederl21025.musicmanagement.real.repositories;

import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Track;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface TrackRepository extends ListCrudRepository<Track, Integer> {
    @Query("SELECT DISTINCT t FROM Track t JOIN t.tags tag WHERE tag IN :tagSet")
    List<Track> findAllTracksHavingSetThatContains(@Param("tagSet") Set<String> tags);
    @Query("SELECT DISTINCT t FROM Track t WHERE KEY(t.metadata) = :queriedKey AND VALUE(t.metadata) = :queriedValue")
    List<Track> findAllTracksHavingKeyValuePair(@Param("queriedKey") String key, @Param("queriedValue") String value);
}