package net.htlgkr.fuerederl21025.musicmanagment.controllers;

import net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.post.CategoryPostDto;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.put.CategoryPutDto;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response.CategoryResponseDto;
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
    public CategoryResponseDto createCategory(@RequestBody CategoryPostDto categoryResponseDto) {
        return null;
    }
    @PutMapping("/{id}")
    public CategoryResponseDto updateCategory(@PathVariable int id, @RequestBody CategoryPutDto categoryResponseDto) {
        return null;
    }
    @GetMapping("/{id}")
    public CategoryResponseDto getCategory(@PathVariable int id) {
        return null;
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
        return null;
    }
}
