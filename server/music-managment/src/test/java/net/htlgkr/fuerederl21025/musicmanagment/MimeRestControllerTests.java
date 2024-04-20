package net.htlgkr.fuerederl21025.musicmanagment;

import jakarta.transaction.Transactional;
import net.htlgkr.fuerederl21025.musicmanagment.controllers.MimeRestController;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.post.MimePostDto;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.put.MimePutDto;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response.MimeResponseDto;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Mime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
        assert mimeResponseDto.name().equals(mimePostDto.name());
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
        MimePostDto mimePostDto1 = new MimePostDto(mimeResponseDto.name());
        assertThrows(ResponseStatusException.class, () -> mimeRestController.createMime(mimePostDto1));
    }
    @Test
    void getTrackThatExists() {
        MimePostDto mimePostDto = new MimePostDto("audio/m4a");
        MimeResponseDto mimeResponseDto = mimeRestController.createMime(mimePostDto);
        assert mimePostDto.name().equals(mimeResponseDto.name());
    }
    @Test
    void getTrackThatDoesNotExist() {
        int id = 9000;
        assertThrows(ResponseStatusException.class, () -> mimeRestController.getMimeById(id));
    }
    @Test
    void updateMime() {
        MimePostDto mimePostDto = new MimePostDto("audio/m4a");
        int id = mimeRestController.createMime(mimePostDto).id();
        MimePutDto mimePutDto = new MimePutDto("audio/flac");
        MimeResponseDto mimeResponseDto = mimeRestController.updateMimeDto(id, mimePutDto);
        assert mimeResponseDto.name().equals("audio/flac");
    }
    @Test
    void updateMimeWithNull() {
        MimePostDto mimePostDto = new MimePostDto("audio/m4a");
        int id = mimeRestController.createMime(mimePostDto).id();
        assertThrows(ResponseStatusException.class, () -> mimeRestController.updateMimeDto(id, null));
    }
    @Test
    void updateMimeWithNameNull() {
        MimePostDto mimePostDto = new MimePostDto("audio/m4a");
        int id = mimeRestController.createMime(mimePostDto).id();
        MimePutDto mimePutDto = new MimePutDto(null);
        assertThrows(ResponseStatusException.class, () -> mimeRestController.updateMimeDto(id, mimePutDto));
    }
    @Test
    void updateMimeWithSameName() {
        MimePostDto mimePostDto = new MimePostDto("audio/m4a");
        int id = mimeRestController.createMime(mimePostDto).id();
        MimePutDto mimePutDto = new MimePutDto("audio/m4a");
        assertThrows(ResponseStatusException.class, () -> mimeRestController.updateMimeDto(id, mimePutDto));
    }
    @Test
    void deleteMime() {
        MimePostDto mimePostDto = new MimePostDto("audio/m4a");
        MimeResponseDto mimeResponseDto = mimeRestController.createMime(mimePostDto);
        assert mimeRestController.deleteMimeDto(mimeResponseDto.id()).equals(mimeResponseDto);
    }
    @Test
    void deleteMimeThatDoesNotExist() {
        int id = 9000;
        assertThrows(ResponseStatusException.class, () -> mimeRestController.deleteMimeDto(id));
    }
    @Test
    void getMimesByName() {
        List<String> mimes = List.of("audio/flac", "audio/mp3", "video/mp4");
        mimes.forEach(x -> {
            mimeRestController.createMime(new MimePostDto(x));
        });
        MimeResponseDto flac = mimeRestController.getMimeByName("audio/flac");
        MimeResponseDto mp3 = mimeRestController.getMimeByName("audio/mp3");
        MimeResponseDto mp4 = mimeRestController.getMimeByName("video/mp4");
        assertIterableEquals(mimes, List.of(flac.name(), mp3.name(), mp4.name()));
    }
    @Test
    void getMimeByNameThatDoesNotExist() {
        assertThrows(ResponseStatusException.class, () -> mimeRestController.getMimeByName("lol/doesnotexist"));
    }
    @Test
    void getAllMimes() {
        List<String> mimes = List.of("audio/flac", "audio/mp3", "video/mp4");
        List<MimeResponseDto> mimeResponseDtos = mimes.stream().map(x -> mimeRestController.createMime(new MimePostDto(x))).toList();
        List<MimeResponseDto> allMimesExisting = mimeRestController.getAllMimes();
        assertIterableEquals(mimeResponseDtos, allMimesExisting);
    }
}
