package net.htlgkr.fuerederl21025.musicmanagment.controllers;

import net.htlgkr.fuerederl21025.musicmanagment.dtos.MimeDto;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Mime;
import net.htlgkr.fuerederl21025.musicmanagment.services.MimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.util.InvalidMimeTypeException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/mimes")
public class MimeRestController {
    @Autowired
    private MimeService mimeService;
    @PostMapping("/")
    public MimeDto createMime(@RequestBody MimeDto mimeDto) {
        Mime mime = new Mime(mimeDto);
        try {
            mime.setMime(mimeDto.mime());
        } catch (InvalidMimeTypeException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        }
        return new MimeDto(mimeService.saveMime(mime));
    }
    @PutMapping("/{id}")
    public MimeDto updateMimeDto(@PathVariable int id, @RequestBody MimeDto mimeDto) {
        Mime mime = mimeService.getMimeById(id);
        try {
            mime.setMime(mimeDto.mime());
        } catch (InvalidMimeTypeException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        }
        return new MimeDto(mimeService.saveMime(mime));
    }
    @GetMapping("/{id}")
    public MimeDto getMimeById(@PathVariable int id) {
        return new MimeDto(mimeService.getMimeById(id));
    }
    @DeleteMapping("/{id}")
    public MimeDto deleteMimeDto(@PathVariable int id) {
        MimeDto mimeDto = new MimeDto(mimeService.getMimeById(id));
        mimeService.deleteMimeById(id);
        return mimeDto;
    }
    @GetMapping("/search")
    public MimeDto getMimeByName(@RequestParam String mime) {
        return new MimeDto(mimeService.getMimeMatching(mime));
    }
    @GetMapping("/")
    public List<MimeDto> getAllMimes() {
        return mimeService.getAllMime().stream().map(MimeDto::new).toList();
    }

}
