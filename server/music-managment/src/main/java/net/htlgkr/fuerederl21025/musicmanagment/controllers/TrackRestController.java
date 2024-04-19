package net.htlgkr.fuerederl21025.musicmanagment.controllers;

import net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.post.TrackPostDto;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.put.TrackPutDto;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response.TrackResponseDto;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.services.CategoryService;
import net.htlgkr.fuerederl21025.musicmanagment.services.TrackService;
import net.htlgkr.fuerederl21025.musicmanagment.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
public class TrackRestController {
    @Autowired
    private TrackService trackService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UrlService urlService;
    @PostMapping("/")
    public TrackResponseDto createTrack(@RequestBody TrackPostDto trackResponseDto) {
        return null;
    }
    @PutMapping("/{id}")
    public TrackResponseDto updateTrack(@PathVariable int id, @RequestBody TrackPutDto trackResponseDto) {
        return null;
    }
    @GetMapping("/{id}")
    public TrackResponseDto getTrack(@PathVariable int id) {
        return null;
    }
    @DeleteMapping("/{id}")
    public TrackResponseDto deleteTrack(@PathVariable int id) {
        return null;
    }
    @GetMapping("/search")
    public List<TrackResponseDto> getAllTracksNamed(@RequestParam String name) {
        return null;
    }
    @GetMapping("/")
    public List<TrackResponseDto> getAllTracks() {
        return null;
    }
    @GetMapping("/category")
    public List<Track> getAllTracksBelongingTo(@RequestParam int id) {
        return null;
    }
}
