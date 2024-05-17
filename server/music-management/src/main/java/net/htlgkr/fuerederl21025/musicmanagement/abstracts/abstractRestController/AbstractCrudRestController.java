package net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractRestController;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.web.bind.annotation.RestController;

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
     * Service facilitating the communication between {@link AbstractCrudRestController} and {@link ListCrudRepository}
     */
    @Autowired
    protected S service;
}
