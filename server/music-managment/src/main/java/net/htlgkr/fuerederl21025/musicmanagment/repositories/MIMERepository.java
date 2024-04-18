package net.htlgkr.fuerederl21025.musicmanagment.repositories;

import net.htlgkr.fuerederl21025.musicmanagment.entities.MIME;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MIMERepository extends ListCrudRepository<MIME, Integer> {
    @Query("SELECT m FROM Mime m WHERE m.mime = :mime")
    Optional<MIME> findMIMEMatching(@Param("mime")String mime);
}
