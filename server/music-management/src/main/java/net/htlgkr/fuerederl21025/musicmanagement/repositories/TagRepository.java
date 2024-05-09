package net.htlgkr.fuerederl21025.musicmanagement.repositories;

import net.htlgkr.fuerederl21025.musicmanagement.entities.Tag;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagRepository extends ListCrudRepository<Tag, Integer> {
    List<Tag> findByName(@Param("name") String name);
}
