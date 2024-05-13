package net.htlgkr.fuerederl21025.musicmanagement.dummy.dummyService;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.EditableCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.dummy.dummyEntity.DummyEntity;
import net.htlgkr.fuerederl21025.musicmanagement.dummy.dummyRepository.DummyRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * This interface is the DummyRepository's service class, separated into it's own file so that
 * Spring boot can do it's magic on it so that {@link AbstractCrudService} can be tested. It is not supposed to be used
 * in production at all ONLY FOR TESTING PURPOSES!
 *
 * @author Leo Füreder
 * @version C.D.
 */
@Service
public class DummyService extends AbstractCrudService<DummyEntity,Integer, DummyRepository> implements EditableCrudService<DummyEntity, Integer> {
    @Override
    public DummyEntity edit(@NonNull DummyEntity newItem, @NonNull Integer integer) {
        if (newItem == null || integer == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        DummyEntity oldItem = getById(integer);
        oldItem.field = newItem.field;
        return save(oldItem);
    }
}
