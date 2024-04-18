package net.htlgkr.fuerederl21025.musicmanagment.services;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public Category addCategory(Category category) {
        if (category == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return categoryRepository.save(category);
    }
    public Category getCategoryById(int id) {
        Category toGet = categoryRepository.findById(id).orElse(null);
        if (toGet == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        return toGet;
    }
    public void deleteCategory(Category category) {
        if (category == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        categoryRepository.delete(category);
    }
    public List<Category> getAllCategoriesNamed(String name) {
        if (name == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return categoryRepository.findAllCategoriesNamed(name);
    }
    public List<Category> getAllCategoriesBelongingTo(Track track) {
        if (track == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return categoryRepository.findAllCategoriesBelongingTo(track);
    }
}
