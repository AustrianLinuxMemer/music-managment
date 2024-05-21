package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractRestController.AbstractCrudRestController;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.URL;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.URL;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.URLService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/urls")
public class URLRestController extends AbstractCrudRestController<URL, Integer, URLService> {
    @Override
    @PostMapping("/")
    public URL add(@RequestBody URL item) {
        return super.add(item);
    }

    @Override
    @GetMapping("/")
    public List<URL> getAll() {
        return super.getAll();
    }

    @Override
    @PutMapping("/{i}")
    public URL replace(@RequestBody URL item, @PathVariable Integer i) {
        return super.replace(item, i);
    }

    @Override
    @GetMapping("/{i}")
    public URL getById(@PathVariable Integer i) {
        return super.getById(i);
    }

    @Override
    @DeleteMapping("/{i}")
    public URL deleteById(Integer i) {
        return super.deleteById(i);
    }
}
