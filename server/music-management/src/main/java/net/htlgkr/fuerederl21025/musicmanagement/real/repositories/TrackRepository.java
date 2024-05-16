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
 *
 * @author Leo Füreder
 * @version C.D.
 */
public interface TrackRepository extends ListCrudRepository<Track, Integer> {
    String QUERY_TO_FILTER_BY_TAG_STRING = "SELECT DISTINCT t FROM Track t WHERE :tagString MEMBER OF t.tags";
    /**
     * This method retrieves all Tracks that have this tag
     * @param tag Tag to be filtering against
     * @return All tracks that have this tag
     */
    @Query(QUERY_TO_FILTER_BY_TAG_STRING)
    List<Track> findAllTracksHavingTag(@Param("tagString") String tag);
}