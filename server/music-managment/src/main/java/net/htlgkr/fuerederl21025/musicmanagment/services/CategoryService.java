package net.htlgkr.fuerederl21025.musicmanagment.services;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.errormessages.ErrorMessages;
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
        if (category == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400), ErrorMessages.NULL_REQUEST_MESSAGE);
        if (category.getName() == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400), ErrorMessages.NULL_VALUE_MESSAGE);
        if (categoryRepository.findByName(category.getName()).isPresent()) throw new ResponseStatusException(HttpStatusCode.valueOf(400), ErrorMessages.ALREADY_EXISTS_MESSAGE);
        return categoryRepository.save(category);
    }
    public Category getCategoryById(int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404), ErrorMessages.DOES_NOT_EXIST_MESSAGE);
        return category;
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }
    public Category getCategoryNamed(String name) {
        if (name == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400), ErrorMessages.NULL_VALUE_MESSAGE);
        Category category = categoryRepository.findByName(name).orElse(null);
        if (category == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404), ErrorMessages.DOES_NOT_EXIST_MESSAGE);
        return category;
    }
}
