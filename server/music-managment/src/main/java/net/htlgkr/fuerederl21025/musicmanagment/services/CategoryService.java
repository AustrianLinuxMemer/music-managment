package net.htlgkr.fuerederl21025.musicmanagment.services;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    public Category createCategory(@NonNull Category category) {
        if (categoryRepository.findByName(category.getName()).isPresent()) throw new EntityExistsException();
        return categoryRepository.save(category);
    }
    public Category saveCategory(@NonNull Category category) {
        if (categoryRepository.findByName(category.getName()).isPresent()) throw new EntityExistsException();
        return categoryRepository.save(category);
    }
    public Category getCategoryById(int id) {
        if (categoryRepository.findById(id).isEmpty()) throw new EntityNotFoundException();
        return categoryRepository.findById(id).get();
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }
    public Category getCategoryNamed(@NonNull String name) {
        if (categoryRepository.findByName(name).isEmpty()) throw new EntityNotFoundException();
        return categoryRepository.findByName(name).get();
    }
}
