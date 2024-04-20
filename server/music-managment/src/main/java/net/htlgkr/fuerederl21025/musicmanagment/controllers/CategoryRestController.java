package net.htlgkr.fuerederl21025.musicmanagment.controllers;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.post.CategoryPostDto;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.put.CategoryPutDto;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response.CategoryResponseDto;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.prepared.exceptions.ResponseStatusExceptions;
import net.htlgkr.fuerederl21025.musicmanagment.services.CategoryService;
import net.htlgkr.fuerederl21025.musicmanagment.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TrackService trackService;
    @PostMapping("/")
    public CategoryResponseDto createCategory(@RequestBody CategoryPostDto categoryPostDto) {
        if (categoryPostDto == null) throw ResponseStatusExceptions.NULL_REQUEST_BODY.get();
        categoryPostDto.accept(ResponseStatusExceptions.NULL_VALUE.get());
        Category category = new Category();
        category.setName(categoryPostDto.name());
        if (categoryPostDto.associatedTracks() != null) {
            category.setTracks(trackService.getAllTracksByIds(categoryPostDto.associatedTracks()));
        } else {
            category.setTracks(null);
        }
        try {
            return CategoryResponseDto.generateNewCategoryResponseDto(categoryService.createCategory(category));
        } catch (EntityExistsException e) {
            throw ResponseStatusExceptions.ALREADY_EXISTS.get();
        }
    }
    @PutMapping("/{id}")
    public CategoryResponseDto updateCategory(@PathVariable int id, @RequestBody CategoryPutDto categoryPutDto) {
        if (categoryPutDto == null) throw ResponseStatusExceptions.NULL_REQUEST_BODY.get();
        categoryPutDto.accept(ResponseStatusExceptions.NULL_VALUE.get());
        try {
            Category category = categoryService.getCategoryById(id);
            if (category.getName().equals(categoryPutDto.name())) throw new EntityExistsException();
            category.setName(categoryPutDto.name());
            return CategoryResponseDto.generateNewCategoryResponseDto(categoryService.saveCategory(category));
        } catch (EntityNotFoundException e) {
            throw ResponseStatusExceptions.NOT_FOUND.get();
        } catch (EntityExistsException e) {
            throw ResponseStatusExceptions.ALREADY_EXISTS.get();
        }
    }
    @GetMapping("/{id}")
    public CategoryResponseDto getCategory(@PathVariable int id) {
        try {
            return CategoryResponseDto.generateNewCategoryResponseDto(categoryService.getCategoryById(id));
        } catch (EntityNotFoundException e) {
            throw ResponseStatusExceptions.NOT_FOUND.get();
        }
    }
    @DeleteMapping("/{id}")
    public CategoryResponseDto deleteCategory(@PathVariable int id) {
        return null;
    }
    @GetMapping("/{name}")
    public CategoryResponseDto getCategoryByName(@PathVariable String name) {
        return null;
    }
    @GetMapping("/all")
    public List<CategoryResponseDto> getAllCategories() {
        return categoryService.getAllCategories().stream().map(CategoryResponseDto::generateNewCategoryResponseDto).toList();
    }
}
