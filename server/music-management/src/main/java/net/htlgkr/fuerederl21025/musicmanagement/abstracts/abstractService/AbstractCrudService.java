package net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService;


import net.htlgkr.fuerederl21025.musicmanagement.real.entities.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

/**
 * This abstract class wraps the {@link ListCrudRepository} into a Service class format to use in basic CRUD use-cases
 * This abstract class needs to be inherited by a subclass and it's public method annotated properly to be used as an
 * actual {@link Service}
 *
 * NOTE: Null checks for {@link NonNull} annotated fields are for runtime-handling of <code>null</code> values
 *
 * @param <T> the type of Entity used
 * @param <ID> the type of primary key used
 * @param <R> the type of repository used
 *
 * @author Leo Füreder
 * @version C.D.
 */
public abstract class AbstractCrudService<T extends BaseEntity<ID>, ID, R extends ListCrudRepository<T, ID>> {
    /**
     * Repository to facilitate communication between the application and the Database
     */
    @Autowired
    protected R listCrudRepository;

    /**
     * This method saves entities that don't yet exist into the Repository
     * @param item Entity to be saved into the Repository
     * @return Entity that was saved into the Repository
     * @throws ResponseStatusException Is thrown with when item is <code>null</code> ({@link HttpStatusCode} 400) and/or
     * when the entity already exists in the repository ({@link HttpStatusCode} 409)
     * repository
     */

    public T save(@NonNull T item) {
        if (item == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        if (item.id != null && existsById(item.id)) throw new ResponseStatusException(HttpStatusCode.valueOf(409), "Entity already exists in the database, use replace instead");
        try {
            return listCrudRepository.save(item);
        } catch (InvalidDataAccessApiUsageException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), e.getMessage());
        }
    }
    /**
     * Retrieves a {@link List<T>} of all entities found in the repository
     * @return A list of all entities found in the repository
     */
    public List<T> getAll() {
        return listCrudRepository.findAll();
    }

    /**
     * This method replaces the old values of an entity with the values of a new item, this method needs to be implemented
     * by subclasses but the expected implementation should do these steps in this order:
     * <list>
     *     <li>Check if the arguments are <code>null</code></li>
     *     <li>Check other things regarding the validity of the data</li>
     *     <li>Change all fields of the entity</li>
     *     <li>Use <code>save()</code> to save the new item</li>
     * </list>
     * @param item The entity with the new values
     * @param id The id of the old entity
     * @return the new entity
     */
    abstract public T replace(@NonNull T item, @NonNull ID id);
    /**
     * This method retrieves a particular Entity identified by <code>id</code>
     * @param id the id used to identify the entity to be retrieved
     * @return The Entity being identified by <code>id</code>
     * @throws ResponseStatusException if no entity is found having this <code>id</code>
     */
    public T getById(@NonNull ID id) {
        if (id == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        T maybeItem = listCrudRepository.findById(id).orElse(null);
        if (maybeItem == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        return maybeItem;
    }

    /**
     * This method deletes a particular entity identified by <code>id</code>, This method calls <code>getById(id)</code>
     * in the background to retrieve the entity before it is deleted from the Repository
     * @param id the id used to identify the entity to be retrieved (as if <code>getById(id)</code> was called)
     * @return the entity being identified by <code>id</code> (as if <code>getById(id)</code> was called)
     */
    public T deleteById(@NonNull ID id) {
        if (id == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        T item = getById(id);
        listCrudRepository.deleteById(id);
        return item;
    }

    /**
     * This method checks if given id is used by an entity in the Repository
     * @param id the id being checked
     * @return <code>true</code> if there is an entity with the given id, <code>false</code> if otherwise
     */

    public boolean existsById(@NonNull ID id) {
        if (id == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return listCrudRepository.existsById(id);
    }
}
