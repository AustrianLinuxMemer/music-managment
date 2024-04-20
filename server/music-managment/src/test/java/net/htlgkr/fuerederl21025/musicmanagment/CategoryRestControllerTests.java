package net.htlgkr.fuerederl21025.musicmanagment;

import jakarta.transaction.Transactional;
import net.htlgkr.fuerederl21025.musicmanagment.controllers.CategoryRestController;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.post.CategoryPostDto;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.put.CategoryPutDto;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response.CategoryResponseDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback
public class CategoryRestControllerTests {
    @Autowired
    CategoryRestController categoryRestController;
    @Test
    void postCategoryWithNull() {
        assertThrows(ResponseStatusException.class, () -> categoryRestController.createCategory(null));
    }
    @Test
    void postCategoryWithNullName() {
        assertThrows(ResponseStatusException.class, () -> categoryRestController.createCategory(new CategoryPostDto(null, null)));
    }
    @Test
    void postCategoryWithNullList() {
        CategoryPostDto categoryPostDto = new CategoryPostDto("Rock", null);
        CategoryResponseDto categoryResponseDto = categoryRestController.createCategory(categoryPostDto);
        assert categoryResponseDto.associatedTracks() == null;
        assert categoryResponseDto.name().equals("Rock");
    }
    @Test
    void postCategoryWithListConsistingOfTracksNotExistingYet() {
        List<Integer> assertedListOfTracks = List.of(2, 4, 6, 8);
        CategoryPostDto categoryPostDto = new CategoryPostDto("Rock", assertedListOfTracks);
        CategoryResponseDto categoryResponseDto = categoryRestController.createCategory(categoryPostDto);
        assert categoryResponseDto.name().equals("Rock");
        assertIterableEquals(new ArrayList<>(), categoryResponseDto.associatedTracks());
    }
    @Test
    void postCategoryWithListConsistingOfNullValuesAndTracksNotExistingYet() {
        List<Integer> listOfTracks = new ArrayList<>(List.of(2, 4, 6, 8));
        listOfTracks.add(2, null);
        listOfTracks.add(4, null);
        CategoryPostDto categoryPostDto = new CategoryPostDto("Rock", listOfTracks);
        CategoryResponseDto categoryResponseDto = categoryRestController.createCategory(categoryPostDto);
        assert categoryResponseDto.name().equals("Rock");
        assertIterableEquals(new ArrayList<>(), categoryResponseDto.associatedTracks());
    }
    @Test
    void postCategoryRepeatedly() {

        List<Integer> assertedListOfTracks = List.of(2, 4, 6, 8);
        CategoryPostDto categoryPostDto = new CategoryPostDto("Rock", assertedListOfTracks);
        categoryRestController.createCategory(categoryPostDto);
        assertThrows(ResponseStatusException.class, () -> {
            categoryRestController.createCategory(categoryPostDto);
        });
    }
    @Test
    void getCategoryById() {
        List<Integer> assertedListOfTracks = List.of(2, 4, 6, 8);
        CategoryPostDto categoryPostDto = new CategoryPostDto("Rock", assertedListOfTracks);
        int id = categoryRestController.createCategory(categoryPostDto).id();
        CategoryResponseDto categoryResponseDto = categoryRestController.getCategory(id);
        assert categoryPostDto.name().equals(categoryResponseDto.name());
        assertIterableEquals(new ArrayList<>(), categoryResponseDto.associatedTracks());
    }
    @Test
    void getCategoryByIdThatDoesNotExist() {
        int id = 9000;
        assertThrows(ResponseStatusException.class, () -> categoryRestController.getCategory(id));
    }
    @Test
    void updatingCategoryName() {
        List<Integer> assertedListOfTracks = new ArrayList<>(List.of(2, 4, 6, 8));
        CategoryPostDto categoryPostDto = new CategoryPostDto("Rock", assertedListOfTracks);
        CategoryResponseDto categoryResponseDto = categoryRestController.createCategory(categoryPostDto);
        int id = categoryResponseDto.id();
        CategoryPutDto categoryPutDto = new CategoryPutDto("Pop", assertedListOfTracks);
        CategoryResponseDto categoryResponseDto1 = categoryRestController.updateCategory(id, categoryPutDto);
        assert categoryResponseDto.name().equals(categoryResponseDto1.name());
    }
    @Test
    void updatingCategoryWithNullInstance() {
        List<Integer> assertedListOfTracks = List.of(2, 4, 6, 8);
        CategoryPostDto categoryPostDto = new CategoryPostDto("Rock", assertedListOfTracks);
        CategoryResponseDto categoryResponseDto = categoryRestController.createCategory(categoryPostDto);
        int id = categoryResponseDto.id();
        assertThrows(ResponseStatusException.class, () -> categoryRestController.updateCategory(id, null));
    }
    @Test
    void updatingCategoryWithNullFields() {
        List<Integer> assertedListOfTracks = List.of(2, 4, 6, 8);
        CategoryPostDto categoryPostDto = new CategoryPostDto("Rock", assertedListOfTracks);
        CategoryResponseDto categoryResponseDto = categoryRestController.createCategory(categoryPostDto);
        int id = categoryResponseDto.id();
        CategoryPutDto categoryPutDto = new CategoryPutDto(null, null);
        assertThrows(ResponseStatusException.class, () -> categoryRestController.updateCategory(id, categoryPutDto));
    }
}
