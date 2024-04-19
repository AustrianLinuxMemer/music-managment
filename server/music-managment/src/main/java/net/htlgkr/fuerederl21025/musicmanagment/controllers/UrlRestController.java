package net.htlgkr.fuerederl21025.musicmanagment.controllers;

import net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.post.UrlPostDto;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response.UrlResponseDto;
import net.htlgkr.fuerederl21025.musicmanagment.services.MimeService;
import net.htlgkr.fuerederl21025.musicmanagment.services.TrackService;
import net.htlgkr.fuerederl21025.musicmanagment.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/urls")
public class UrlRestController {
    @Autowired
    UrlService urlService;
    @Autowired
    MimeService mimeService;
    @Autowired
    TrackService trackService;
    @PostMapping("/")
    public UrlResponseDto createUrl(@RequestBody UrlPostDto urlResponseDto) {
        return null;
    }
    @PutMapping("/{id}")
    public UrlResponseDto updateUrl(@PathVariable int id, @RequestBody UrlPostDto urlResponseDto) {
        return null;
    }
    @GetMapping("/{id}")
    public UrlResponseDto getUrl(@PathVariable int id) {
        return null;
    }
    @DeleteMapping("/{id}")
    public UrlResponseDto deleteUrl(@PathVariable int id) {
        return null;
    }
    @GetMapping("/")
    public List<UrlResponseDto> getAllUrls() {
        return null;
    }
    @GetMapping("/search")
    public List<UrlResponseDto> getAllUrlsMatchingCriteria(@RequestParam(required = false) Integer mimeId, @RequestParam(required = false) Integer trackId) {
        if (mimeId != null) {
            return null;
        }
        if (trackId != null) {
            return null;
        }
        return null;
    }
}
