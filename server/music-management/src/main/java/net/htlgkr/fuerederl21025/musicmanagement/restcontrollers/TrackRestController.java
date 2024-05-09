package net.htlgkr.fuerederl21025.musicmanagement.restcontrollers;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractRestController.AbstractCrudRestController;
import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.repositories.TrackRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
public class TrackRestController extends AbstractCrudRestController<Track, Integer, AbstractCrudService<Track, Integer, TrackRepository>> {
    @Override
    @PostMapping("/")
    public Track add(@RequestBody Track item) {
        return super.add(item);
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
}
