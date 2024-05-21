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
    public Tag add(@RequestBody Tag item) {
        return super.add(item);
    }

    @Override
    @GetMapping("/")
    public List<Tag> getAll() {
        return super.getAll();
    }

    @Override
    @PutMapping("/{s}")
    public Tag replace(@RequestBody Tag item, @PathVariable String s) {
        return super.replace(item, s);
    }

    @Override
    @GetMapping("/{s}")
    public Tag getById(@PathVariable String s) {
        return super.getById(s);
    }

    @Override
    @DeleteMapping("/{s}")
    public Tag deleteById(String s) {
        return super.deleteById(s);
    }
}
