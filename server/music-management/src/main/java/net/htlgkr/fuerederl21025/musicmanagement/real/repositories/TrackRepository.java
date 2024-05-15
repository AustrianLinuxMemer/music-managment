package net.htlgkr.fuerederl21025.musicmanagement.real.repositories;

import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Track;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;


/**
 * This interface provides the CRUD queries of {@link ListCrudRepository} with my own custom queries
 * for tags and custom mime
 */
public interface TrackRepository extends ListCrudRepository<Track, Integer> {
    String QUERY_TO_FILTER_BY_TAG_STRINGS = "SELECT DISTINCT t FROM Track t JOIN t.tags tag WHERE tag IN :tagSet";
    String QUERY_TO_FILTER_BY_KEY_AND_VALUE = "SELECT DISTINCT t FROM Track t WHERE KEY(t.mime) = :queriedKey AND VALUE(t.mime) = :queriedValue";
    /**
     * This method retrieves all Tracks that have one or more tag strings in their set of tag strings
     * @param tags Tags to check again
     * @return All tracks that has one or more tag strings in their set of tags
     */
    @Query(QUERY_TO_FILTER_BY_TAG_STRINGS)
    List<Track> findAllTracksHavingSetThatContains(@Param("tagSet") Set<String> tags);

    /**
     * This method retrieves all tracks that have the Key and the Value you query
     * @param key The key you check against
     * @param value The value you check against
     * @return All tracks that have the key and the value
     */
    @Query(QUERY_TO_FILTER_BY_KEY_AND_VALUE)
    List<Track> findAllTracksHavingKeyValuePair(@Param("queriedKey") String key, @Param("queriedValue") String value);
}