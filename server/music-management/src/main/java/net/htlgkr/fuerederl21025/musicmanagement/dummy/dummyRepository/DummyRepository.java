package net.htlgkr.fuerederl21025.musicmanagement.dummy.dummyRepository;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.dummy.dummyEntity.DummyEntity;
import org.springframework.data.repository.ListCrudRepository;

/**
 * This interface is the DummyEntity's {@link ListCrudRepository} interface, separated into it's own file so that
 * Spring boot can do it's magic on it so that {@link AbstractCrudService} can be tested. It is not supposed to be used
 * in production at all ONLY FOR TESTING PURPOSES!
 * @author Leo Füreder
 * @version C.D.
 */
public interface DummyRepository extends ListCrudRepository<DummyEntity, Integer> {
}
