package net.htlgkr.fuerederl21025.musicmanagement.stateful.repositories;

import net.htlgkr.fuerederl21025.musicmanagement.stateful.entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface CategoryRepository extends ListCrudRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.name = ?1")
    Optional<Category> findCategoryByName(String name);
}
