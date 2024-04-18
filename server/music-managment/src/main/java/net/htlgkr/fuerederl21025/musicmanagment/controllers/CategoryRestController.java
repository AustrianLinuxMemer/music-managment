package net.htlgkr.fuerederl21025.musicmanagment.controllers;

import net.htlgkr.fuerederl21025.musicmanagment.dtos.CategoryDto;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.services.CategoryService;
import net.htlgkr.fuerederl21025.musicmanagment.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TrackService trackService;
    @PostMapping("/")
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.name());
        category.setTracks(trackService.getAllTracksByIds(categoryDto.associatedTracks()));
        return new CategoryDto(categoryService.saveCategory(category));
    }
    @PutMapping("/{id}")
    public CategoryDto updateCategory(@PathVariable int id, @RequestBody CategoryDto categoryDto) {
        Category category = categoryService.getCategoryById(id);
        category.setName(categoryDto.name());
        category.setTracks(trackService.getAllTracksByIds(categoryDto.associatedTracks()));
        return new CategoryDto(categoryService.saveCategory(category));
    }
    @GetMapping("/{id}")
    public CategoryDto getCategory(@PathVariable int id) {
        return new CategoryDto(categoryService.getCategoryById(id));
    }
    @DeleteMapping("/{id}")
    public CategoryDto deleteCategory(@PathVariable int id) {
        CategoryDto categoryDto = new CategoryDto(categoryService.getCategoryById(id));
        categoryService.deleteCategoryById(id);
        return categoryDto;
    }
    @GetMapping("/search")
    public List<CategoryDto> getAllCategoriesLike(@RequestParam String name) {
        return categoryService.getAllCategoriesNamedLike(name).stream().map(CategoryDto::new).toList();
    }
    @GetMapping("/all")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories().stream().map(CategoryDto::new).toList();
    }
}
