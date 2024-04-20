package net.htlgkr.fuerederl21025.musicmanagment.repositories;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Mime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface MimeRepository extends ListCrudRepository<Mime, Integer> {
    boolean existsByName(String name);
    @Query("SELECT m FROM Mime m WHERE m.name = ?1")
    Optional<Mime> findByName(String name);
}
