package net.htlgkr.fuerederl21025.musicmanagment.repositories;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Mime;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface MimeRepository extends ListCrudRepository<Mime, Integer> {
    Optional<Mime> findByMime(String mime);
}
