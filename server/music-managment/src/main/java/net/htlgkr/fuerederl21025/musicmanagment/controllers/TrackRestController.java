package net.htlgkr.fuerederl21025.musicmanagment.controllers;

import net.htlgkr.fuerederl21025.musicmanagment.dtos.TrackDto;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.services.CategoryService;
import net.htlgkr.fuerederl21025.musicmanagment.services.TrackService;
import net.htlgkr.fuerederl21025.musicmanagment.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    public TrackDto createTrack(@RequestBody TrackDto trackDto) {
        Track track = new Track();
        track.setName(trackDto.name());
        track.setCategories(trackDto.listOfAssociatedCategories().stream().map(categoryService::getCategoryById).toList());
        track.setURLs(trackDto.listOfAssociatedURLs().stream().map(urlService::getUrlById).toList());
        track.setSourceURL(urlService.getUrlById(trackDto.source().id()));
        track.setTrackUniqueMetadata(trackDto.trackUniqueMetadata());
        return new TrackDto(trackService.saveTrack(track));
    }
    @PutMapping("/{id}")
    public TrackDto updateTrack(@PathVariable int id, @RequestBody TrackDto trackDto) {
        Track track = trackService.getTrackById(id);
        track.setName(trackDto.name());
        track.setCategories(trackDto.listOfAssociatedCategories().stream().map(categoryService::getCategoryById).toList());
        track.setURLs(trackDto.listOfAssociatedURLs().stream().map(urlService::getUrlById).toList());
        track.setSourceURL(urlService.getUrlById(trackDto.source().id()));
        track.setTrackUniqueMetadata(trackDto.trackUniqueMetadata());
        return new TrackDto(trackService.saveTrack(track));
    }
    @GetMapping("/{id}")
    public TrackDto getTrack(@PathVariable int id) {
        return new TrackDto(trackService.getTrackById(id));
    }
    @DeleteMapping("/{id}")
    public TrackDto deleteTrack(@PathVariable int id) {
        TrackDto trackDto = new TrackDto(trackService.getTrackById(id));
        trackService.deleteTrack(id);
        return trackDto;
    }
    @GetMapping("/search")
    public List<TrackDto> getAllTracksNamed(@RequestParam String name) {
        return trackService.getAllTracksNamedLike(name).stream().map(TrackDto::new).toList();
    }
    @GetMapping("/")
    public List<TrackDto> getAllTracks() {
        return trackService.getAllTracks().stream().map(TrackDto::new).toList();
    }
    @GetMapping("/category")
    public List<Track> getAllTracksBelongingTo(@RequestParam int id) {
        return trackService.getAllTracksBelongingTo(categoryService.getCategoryById(id));
    }
}
