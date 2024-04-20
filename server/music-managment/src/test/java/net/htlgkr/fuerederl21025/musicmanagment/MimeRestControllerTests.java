package net.htlgkr.fuerederl21025.musicmanagment;

import jakarta.transaction.Transactional;
import net.htlgkr.fuerederl21025.musicmanagment.controllers.MimeRestController;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.post.MimePostDto;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response.MimeResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
public class MimeRestControllerTests {
    @Autowired
    MimeRestController mimeRestController;
    @Test
    void createValidMime() {
        MimePostDto mimePostDto = new MimePostDto("audio/flac+somethingelse");
        MimeResponseDto mimeResponseDto = mimeRestController.createMime(mimePostDto);
        assert mimeResponseDto.mime().equals(mimePostDto.mime());
    }
    @Test
    void createInvalidMime() {
        MimePostDto mimePostDto = new MimePostDto("33+9js//+");
        assertThrows(ResponseStatusException.class, () -> mimeRestController.createMime(mimePostDto));
    }
    @Test
    void createNullMime() {
        assertThrows(ResponseStatusException.class, () -> mimeRestController.createMime(null));
    }
    @Test
    void createMimeWithNullAsMime() {
        MimePostDto mimePostDto = new MimePostDto(null);
        assertThrows(ResponseStatusException.class, () -> mimeRestController.createMime(mimePostDto));
    }
    @Test
    void createSameMimeRepeated() {
        MimePostDto mimePostDto = new MimePostDto("audio/m4a");
        MimeResponseDto mimeResponseDto = mimeRestController.createMime(mimePostDto);
        MimePostDto mimePostDto1 = new MimePostDto(mimeResponseDto.mime());
        assertThrows(ResponseStatusException.class, () -> mimeRestController.createMime(mimePostDto1));
    }
}
