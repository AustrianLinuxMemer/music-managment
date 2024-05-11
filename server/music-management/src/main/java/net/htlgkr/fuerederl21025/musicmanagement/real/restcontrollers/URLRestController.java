package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractRestController.AbstractCrudRestController;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.URL;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.URLService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/urls")
public class URLRestController extends AbstractCrudRestController<URL, Integer, URLService> {
    @PostMapping("/")
    @Override
    public URL saveNew(@RequestBody URL item) {
        return super.saveNew(item);
    }
    @PutMapping("/{id}")
    @Override
    public URL update(@RequestBody URL newItem, @PathVariable Integer integer) {
        return super.update(newItem, integer);
    }
    @GetMapping("/{id}")
    @Override
    public URL getById(@PathVariable Integer integer) {
        return super.getById(integer);
    }
    @GetMapping("/")
    @Override
    public List<URL> getAll() {
        return super.getAll();
    }
    @DeleteMapping("/{id}")
    @Override
    public URL deleteById(@PathVariable Integer integer) {
        return super.deleteById(integer);
    }
}
