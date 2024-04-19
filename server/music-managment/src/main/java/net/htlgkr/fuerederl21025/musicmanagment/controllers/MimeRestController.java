package net.htlgkr.fuerederl21025.musicmanagment.controllers;

import net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.post.MimePostDto;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.put.MimePutDto;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response.MimeResponseDto;
import net.htlgkr.fuerederl21025.musicmanagment.services.MimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mimes")
public class MimeRestController {
    @Autowired
    private MimeService mimeService;
    @PostMapping("/")
    public MimeResponseDto createMime(@RequestBody MimePostDto mimeResponseDto) {
        return null;
    }
    @PutMapping("/{id}")
    public MimeResponseDto updateMimeDto(@PathVariable int id, @RequestBody MimePutDto mimeResponseDto) {
        return null;
    }
    @GetMapping("/{id}")
    public MimeResponseDto getMimeById(@PathVariable int id) {
        return null;
    }
    @DeleteMapping("/{id}")
    public MimeResponseDto deleteMimeDto(@PathVariable int id) {
        return null;
    }
    @GetMapping("/search")
    public MimeResponseDto getMimeByName(@RequestParam String mime) {
        return null;
    }
    @GetMapping("/")
    public List<MimeResponseDto> getAllMimes() {
        return null;
    }

}
