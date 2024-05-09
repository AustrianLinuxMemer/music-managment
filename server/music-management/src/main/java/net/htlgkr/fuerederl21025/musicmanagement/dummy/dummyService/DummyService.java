package net.htlgkr.fuerederl21025.musicmanagement.dummy.dummyService;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.dummy.dummyEntity.DummyEntity;
import net.htlgkr.fuerederl21025.musicmanagement.dummy.dummyRepository.DummyRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;
/**
 * This interface is the DummyRepository's service class, separated into it's own file so that
 * Spring boot can do it's magic on it so that {@link AbstractCrudService} can be tested. It is not supposed to be used
 * in production at all ONLY FOR TESTING PURPOSES!
 *
 * @author Leo Füreder
 * @version C.D.
 */
@Service
public class DummyService extends AbstractCrudService<DummyEntity, Integer, DummyRepository> {
}
