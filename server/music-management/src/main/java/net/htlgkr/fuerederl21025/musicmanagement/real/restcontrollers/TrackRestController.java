package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractRestController.AbstractCrudRestController;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.TrackService;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/tracks")
public class TrackRestController extends AbstractCrudRestController<Track, Integer, TrackService> {
    @Override
    @PostMapping("/")
    public Track saveNew(@RequestBody Track item) {
        return super.saveNew(item);
    }

    @Override
    @PutMapping("/{id}")
    public Track update(@RequestBody Track newItem, @PathVariable Integer id) {
        return super.update(newItem, id);
    }

    @Override
    @GetMapping("/{id}")
    public Track getById(@PathVariable Integer id) {
        return super.getById(id);
    }

    @Override
    @GetMapping("/")
    public List<Track> getAll() {
        return super.getAll();
    }

    @Override
    @DeleteMapping("/{id}")
    public Track deleteById(Integer id) {
        return super.deleteById(id);
    }
    @GetMapping("/tag?{tags}=")
    public List<Track> getAllTracksTaggedWith(@RequestParam Set<String> tags) {
        try {
            return service.getAllTracksHavingSetThatContains(tags);
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), e.getMessage());
        }
    }
    @GetMapping("/name?{key}=&{value}=")
    public List<Track> getAllTracksWithKeyValuePair(@RequestParam String key, @RequestParam String value) {
        try {
            return service.getAllTracksWithKeyValuePair(key, value);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), e.getMessage());
        }
    }
}
