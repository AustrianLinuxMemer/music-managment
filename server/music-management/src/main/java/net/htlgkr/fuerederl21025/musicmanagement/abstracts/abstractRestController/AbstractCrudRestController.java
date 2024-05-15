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
public abstract class AbstractCrudRestController<T extends BaseEntity<ID> & ToDto<DTO>, DTO extends FromDto<T>,ID, S extends AbstractCrudService<T, ID, ? extends ListCrudRepository<T, ID>>> {

    /**
     * Service facilitating the communication between RestController and Repository
     */
    @Autowired
    protected S service;
    public DTO save(DTO item) {
        try {
            T entity = item.fromDtoWithoutID();
            return service.save(entity).toDtoWithID();
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), e.getMessage());
        }
    }
    public DTO replace(DTO newItem, ID id) {
        T entity = newItem.fromDtoWithoutID();
        return service.edit(entity, id).toDtoWithID();
    }
    public DTO getById(ID id) {
        return service.getById(id).toDtoWithID();
    }
    public List<DTO> getAll() {
        return service.getAll().stream().map(ToDto::toDtoWithID).toList();
    }
    public DTO deleteById(ID id) {
        return service.deleteById(id).toDtoWithID();
    }
}
