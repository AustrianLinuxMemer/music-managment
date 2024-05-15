package net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractRestController;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

/**
 * This abstract class wraps the {@link AbstractCrudService} into a RestController format to use in basic CRUD use-cases
 * This abstract class needs to be inherited by a subclass and it's public method annotated properly to be used as an
 * actual {@link RestController}
 *
 * @param <T>  the type of Entity used
 * @param <ID> the type of primary key used
 * @param <S> the type of service used
 *
 * @author Leo Füreder
 * @version C.D.
 */
public abstract class AbstractCrudRestController<T extends BaseEntity<ID>, ID, S extends AbstractCrudService<T, ID, ? extends ListCrudRepository<T, ID>>> {

    /**
     * Service facilitating the communication between RestController and Repository
     */
    @Autowired
    protected S service;
    public T save(T item) {
        try {
            return service.save(item);
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), e.getMessage());
        }
    }
    public T replace(T newItem, ID id) {
        return service.edit(newItem, id);
    }
    public T getById(ID id) {
        return service.getById(id);
    }
    public List<T> getAll() {
        return service.getAll();
    }
    public T deleteById(ID id) {
        return service.deleteById(id);
    }
}
