package net.htlgkr.fuerederl21025.musicmanagement.isolatedServices;

import jakarta.transaction.Transactional;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Tag;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class TagTest {
    @Autowired
    TagService tagService;

    @Test
    void saveTag() {
        Tag tag = new Tag("Rock", null, Map.of("Key1", "Value1", "Key2", "Value2"));
        Tag tag2 = tagService.save(tag);
        assertEquals(tag2.id, tag.id);
        assertEquals(tag.tracks, tag2.tracks);
    }
    @Test
    void tagDoesNotExist() {
        assertFalse(tagService.existsById("Rock"));
    }
    @Test
    void tagDoesExist() {
        Tag tag = new Tag("Rock", null, Map.of("Key1", "Value1", "Key2", "Value2"));
        tagService.save(tag);
        assertTrue(tagService.existsById("Rock"));
    }
    @Test
    void deleteTagThatExists() {
        Tag tag = new Tag("Rock", null, Map.of("Key1", "Value1", "Key2", "Value2"));
        tagService.save(tag);
        tagService.deleteById(tag.id);
        assertFalse(tagService.existsById(tag.id));
    }
    @Test
    void deleteTagThatDoesNotExist() {
        assertThrows(ResponseStatusException.class, () -> tagService.deleteById("Rock"));
    }
    @Test
    void getTagThatDoesExist() {
        Tag tag = new Tag("Rock", null, Map.of("Key1", "Value1", "Key2", "Value2"));
        tagService.save(tag);
        Tag tag2 = tagService.getById("Rock");
        assertEquals(tag2.id, tag.id);
        assertEquals(tag.tracks, tag2.tracks);
    }
    @Test
    void getTagThatDoesNotExist() {
        assertThrows(ResponseStatusException.class, () -> tagService.getById("Rock"));
    }
}
