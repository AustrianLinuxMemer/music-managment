package net.htlgkr.fuerederl21025.musicmanagment.services;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }
    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.findById(id);
    }
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }
    public List<Category> getAllCategoriesNamed(String name) {
        return categoryRepository.findAllCategoriesNamed(name);
    }
    public List<Category> getAllCategoriesBelongingTo(Track track) {
        return categoryRepository.findAllCategoriesBelongingTo(track);
    }
}
