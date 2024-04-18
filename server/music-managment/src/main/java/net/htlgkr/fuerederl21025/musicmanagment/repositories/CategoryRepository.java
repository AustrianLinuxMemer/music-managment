package net.htlgkr.fuerederl21025.musicmanagment.repositories;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CategoryRepository extends ListCrudRepository<Category, Integer> {
    List<Category> findByNameLike(String name);
    List<Category> findByTracks(Track tracks);
}
