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
     * This method saves entities into the Repository
     * @param item Entity to be saved into the Repository
     * @return Entity that was saved into the Repository
     * @throws ResponseStatusException Is thrown when item is <code>null</code>
     */

    public T save(@NonNull T item) {
        try {
            return listCrudRepository.save(item);
        } catch (InvalidDataAccessApiUsageException e){
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
     * This method retrieves a particular Entity identified by <code>id</code>
     * @param id the id used to identify the entity to be retrieved
     * @return The Entity being identified by <code>id</code>
     * @throws ResponseStatusException if no entity is found having this <code>id</code>
     */
    public T getById(@NonNull ID id) {
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
        return listCrudRepository.existsById(id);
    }
}