package net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractRestController;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public abstract class AbstractCrudRestController<T, ID, S extends AbstractCrudService<T, ID, ? extends ListCrudRepository<T, ID>>> {
    @Autowired
    protected S service;
    public T add(T item) {
        try {
            return service.save(item);
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), e.getMessage());
        }
    }
    public T update(T newItem, ID id) {
        try {
            return service.update(newItem, id);
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), e.getMessage());
        }
    }
    public T getById(ID id) {
        try {
            return service.getById(id);
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), e.getMessage());
        }
    }
    public List<T> getAll() {
        return service.getAll();
    }
    public T deleteById(ID id) {
        try {
            return service.deleteById(id);
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), e.getMessage());
        }
    }
}
