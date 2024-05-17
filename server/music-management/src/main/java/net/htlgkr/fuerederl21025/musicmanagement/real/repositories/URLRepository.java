package net.htlgkr.fuerederl21025.musicmanagement.real.repositories;

import net.htlgkr.fuerederl21025.musicmanagement.real.entities.URL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface URLRepository extends ListCrudRepository<URL, Integer> {
    @Query("SELECT DISTINCT u FROM URL u WHERE u.mime = :mimeString")
    List<URL> getAllURLsHavingMime(@Param("mimeString") String mime);
}
