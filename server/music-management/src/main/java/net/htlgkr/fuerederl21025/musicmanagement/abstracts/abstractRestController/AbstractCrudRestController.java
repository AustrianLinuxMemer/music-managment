package net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractRestController;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.BaseEntity;
import net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers.dto.FromDto;
import net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers.dto.ToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * This abstract class wraps the {@link AbstractCrudService} into a RestController format to use in basic CRUD use-cases
 * This abstract class needs to be inherited by a subclass and it's public method annotated properly to be used as an
 * actual {@link RestController}
 *
 * @param <T>  the type of Entity used
 * @param <DTO> the corresponding DTO used
 * @param <ID> the type of primary key used
 * @param <S> the type of service used
 *
 * @author Leo Füreder
 * @version C.D.
 */
public abstract class AbstractCrudRestController<T extends BaseEntity<ID> & ToDto<DTO>, DTO extends FromDto<T>,ID, S extends AbstractCrudService<T, ID, ? extends ListCrudRepository<T, ID>>> {

    /**
     * Service facilitating the communication between {@link AbstractCrudRestController} and {@link ListCrudRepository}
     */
    @Autowired
    protected S service;

    /**
     * Delegates to the {@link AbstractCrudService#save(T)} method
     * @param item The item to be saved
     * @return The item saved
     */
    public DTO save(DTO item) {
        T entity = item.fromDtoWithoutID();
        return service.save(entity).toDtoWithID();
    }

    /**
     * Delegates to the {@link AbstractCrudService#replace(T, ID)}method
     * @param newItem The new item to be saved
     * @param id The id of the old Entity
     * @return the new item
     */
    public DTO replace(DTO newItem, ID id) {
        T entity = newItem.fromDtoWithoutID();
        return service.replace(entity, id).toDtoWithID();
    }

    /**
     * Delegates to the {@link AbstractCrudService#getById(ID)} method
     * @param id The id of the item to be retrieved
     * @return The item retrieved
     */
    public DTO getById(ID id) {
        return service.getById(id).toDtoWithID();
    }

    /**
     * Delegates to the {@link AbstractCrudService#getAll()} method
     * @return A list of all items existing
     */
    public List<DTO> getAll() {
        return service.getAll().stream().map(ToDto::toDtoWithID).toList();
    }

    /**
     * Delegates to the {@link AbstractCrudService#deleteById(ID)} method
     * @param id The id of the item to be deleted
     * @return the deleted item
     */
    public DTO deleteById(ID id) {
        return service.deleteById(id).toDtoWithID();
    }
}
