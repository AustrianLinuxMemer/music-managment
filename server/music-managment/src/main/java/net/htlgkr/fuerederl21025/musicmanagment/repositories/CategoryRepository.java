package net.htlgkr.fuerederl21025.musicmanagment.repositories;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.name = :name")
    List<Category> findAllCategoriesNamed(@Param("name")String name);
    @Query("SELECT c FROM Category c WHERE :track MEMBER OF c.tracks")
    List<Category> findAllCategoriesBelongingTo(@Param("track")Track track);
}
