package net.htlgkr.fuerederl21025.musicmanagment.services;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public Category saveCategory(Category category) {
        if (category == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return categoryRepository.save(category);
    }
    public Category getCategoryById(int id) {
        Category toGet = categoryRepository.findById(id).orElse(null);
        if (toGet == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        return toGet;
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }
    public List<Category> getAllCategoriesNamedLike(String name) {
        if (name == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return categoryRepository.findByNameLike(name);
    }
}
