package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractRestController.AbstractCrudRestController;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.TrackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
public class TrackRestController extends AbstractCrudRestController<Track, Integer, TrackService> {
    @Override
    @PostMapping("/")
    public Track add(@RequestBody Track item) {
        return super.add(item);
    }

    @Override
    @GetMapping("/")
    public List<Track> getAll() {
        return super.getAll();
    }

    @Override
    @PutMapping("/{i}")
    public Track replace(@RequestBody Track item, @PathVariable Integer i) {
        return super.replace(item, i);
    }

    @Override
    @GetMapping("/{i}")
    public Track getById(@PathVariable Integer i) {
        return super.getById(i);
    }

    @Override
    @DeleteMapping("/{i}")
    public Track deleteById(Integer i) {
        return super.deleteById(i);
    }
    @GetMapping("/search")
    public List<Track> getAllTracksHavingTag(@RequestParam String tag) {
        return service.findAllTracksHavingTag(tag);
    }
}
