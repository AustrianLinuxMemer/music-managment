package net.htlgkr.fuerederl21025.musicmanagment.repositories;

import net.htlgkr.fuerederl21025.musicmanagment.entities.MIME;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.entities.URL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface URLRepository extends ListCrudRepository<URL, Integer> {
    @Query("SELECT u FROM URL u WHERE u.mime = :mime")
    List<URL> findAllURLsUsingMimeType(@Param("mime")MIME mime);
    @Query("SELECT u FROM URL u WHERE u.track = :track")
    List<URL> findAllURLsAssociatedWithTrack(@Param("track")Track track);
}
