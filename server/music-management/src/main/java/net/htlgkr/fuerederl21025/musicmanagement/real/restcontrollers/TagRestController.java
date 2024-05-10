package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractRestController.AbstractCrudRestController;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Tag;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/tags")
public class TagRestController extends AbstractCrudRestController<Tag, String, TagService> {
    @Override
    @PostMapping("/")
    public Tag saveNew(@RequestBody Tag item) {
        return super.saveNew(item);
    }

    @Override
    @PutMapping("/{id}")
    public Tag update(@RequestBody Tag newItem, @PathVariable String id) {
        return super.update(newItem, id);
    }

    @Override
    @GetMapping("/{id}")
    public Tag getById(@PathVariable String id) {
        return super.getById(id);
    }

    @Override
    @GetMapping("/")
    public List<Tag> getAll() {
        return super.getAll();
    }

    @Override
    @DeleteMapping("/{id}")
    public Tag deleteById(@PathVariable String id) {
        return super.deleteById(id);
    }
}
