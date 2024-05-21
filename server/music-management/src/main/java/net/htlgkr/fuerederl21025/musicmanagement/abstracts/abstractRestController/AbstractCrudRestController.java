package net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractRestController;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.web.bind.annotation.RestController;

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
public abstract class AbstractCrudRestController<T ,ID, S extends AbstractCrudService<T, ID, ? extends ListCrudRepository<T, ID>>> {

    /**
     * Service abstracting away the error handling
     */
    @Autowired
    protected S service;

    /**
     * Delegates to {@link AbstractCrudService#save(T item)}
     * @param item The item to be saved
     * @return The item saved
     */
    public T add(T item) {
        return service.save(item);
    }

    /**
     * Delegates to {@link AbstractCrudService#getAll()}
     * @return All items in the database
     */
    public List<T> getAll() {
        return service.getAll();
    }

    /**
     * Delegates to {@link AbstractCrudService#replace(T, ID)}
     * @param item The new item
     * @param id The id of the old item
     * @return The old object with the changes applied
     */
    public T replace(T item, ID id) {
        return service.replace(item, id);
    }

    /**
     * Delegates to {@link AbstractCrudService#getById(ID)}
     * @param id The id of the object in question
     * @return The object with that id
     */
    public T getById(ID id) {
        return service.getById(id);
    }

    /**
     * Delegates to {@link AbstractCrudService#deleteById(ID)}
     * @param id The id of the item being deleted
     * @return The deleted item
     */
    public T deleteById(ID id) {
        return service.deleteById(id);
    }

    /**
     * Delegates to {@link AbstractCrudService#existsById(ID)}
     * @param id The id of the item that is in question
     * @return <code>true</code> if the item exists, otherwise <code>false</code>
     */
    public boolean existsById(ID id) {
        return service.existsById(id);
    }
}
