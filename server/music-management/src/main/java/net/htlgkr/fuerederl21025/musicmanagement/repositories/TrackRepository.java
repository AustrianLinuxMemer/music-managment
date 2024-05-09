package net.htlgkr.fuerederl21025.musicmanagement.repositories;

import net.htlgkr.fuerederl21025.musicmanagement.entities.Tag;
import net.htlgkr.fuerederl21025.musicmanagement.entities.Track;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface TrackRepository extends ListCrudRepository<Track, Integer> {
    @Query("SELECT DISTINCT t FROM Track t JOIN t.tags tag WHERE tag.name IN :tagSet")
    List<Track> findAllTracksTaggedWith(@Param("tagSet") Set<String> tags);
    @Query("SELECT DISTINCT t FROM Track t WHERE KEY(t.individualMetadata) = :queriedKey AND VALUE(t.individualMetadata) = :queriedValue")
    List<Track> findAllTracksHavingKeyValuePair(@Param("queriedKey") String key, @Param("queriedValue") String value);
}