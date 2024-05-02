package net.htlgkr.fuerederl21025.musicmanagement.restcontrollers;

import net.htlgkr.fuerederl21025.musicmanagement.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
public class TrackRestController {
    @Autowired
    private TrackService trackService;
    @PostMapping("/")
    public Track addTrack(@RequestBody Track track) {
        return trackService.addTrack(track);
    }
    @GetMapping("/all")
    public List<Track> getAllTracks() {
        return trackService.getAllTracks();
    }
    @GetMapping("/{id}")
    public Track getTrackById(@PathVariable int id) {
        return trackService.getTrackById(id);
    }
    @PutMapping("/{id}")
    public Track replaceTrack(@PathVariable int id, @RequestBody Track newTrack) {
        trackService.deleteTrack(id);
        return trackService.addTrack(newTrack);
    }
    @DeleteMapping("/{id}")
    public Track deleteTrack(@PathVariable int id) {
        return trackService.deleteTrack(id);
    }
}
