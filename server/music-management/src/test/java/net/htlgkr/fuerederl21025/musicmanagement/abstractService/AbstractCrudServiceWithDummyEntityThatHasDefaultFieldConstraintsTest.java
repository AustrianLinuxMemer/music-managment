package net.htlgkr.fuerederl21025.musicmanagement.abstractService;

import jakarta.transaction.Transactional;
import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.dummy.dummyEntity.DummyEntity;
import net.htlgkr.fuerederl21025.musicmanagement.dummy.dummyService.DummyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This test is to test {@link AbstractCrudService}, it uses a defined-on-the-spot
 * {@link DummyEntity} as an Entity and {@link java.lang.Integer} for the primary key
 * This is to avoid testing for each "real" entity and it's services.
 * Default field constraints mean <code>@Column(unique=false, nullable=true)</code>
 * And yes, I'm dead serious about this name. Deal with it
 *
 * @author Leo Füreder
 * @version C.D.
 */

@SpringBootTest
@Transactional
@Rollback
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class AbstractCrudServiceWithDummyEntityThatHasDefaultFieldConstraintsTest {
    @Autowired
    DummyService dummyService;
    @Test
    void addEntity() {
        DummyEntity dummyEntity = new DummyEntity("value");
        DummyEntity dummyEntity2 = dummyService.save(dummyEntity);
        assertEquals(dummyEntity.field, dummyEntity2.field);
    }
    @Test
    void addNull() {
        assertThrows(ResponseStatusException.class, () -> dummyService.save(null));
    }
    @Test
    void addNullValuedEntity() {
        DummyEntity dummyEntity = new DummyEntity(null);
        DummyEntity dummyEntity2 = dummyService.save(dummyEntity);
        assertEquals(dummyEntity.field, dummyEntity2.field);
    }
    @Test
    void entityExists() {
        DummyEntity dummyEntity = new DummyEntity("value");
        DummyEntity dummyEntity2 = dummyService.save(dummyEntity);
        assertTrue(dummyService.existsById(dummyEntity2.id));
    }
    @Test
    void entityDoesNotExist() {
        assertFalse(dummyService.existsById(9000));
    }
    @Test
    void getEntityThatExists() {
        DummyEntity dummyEntity = new DummyEntity("value");
        DummyEntity dummyEntity2 = dummyService.save(dummyEntity);
        DummyEntity dummyEntity3 = dummyService.getById(dummyEntity2.id);
        assertEquals(dummyEntity.field, dummyEntity3.field);
    }
    @Test
    void getEntityThatDoesNotExist() {
        assertThrows(ResponseStatusException.class, () -> dummyService.getById(9000));
    }
    @Test
    void removeEntityThatExists() {
        DummyEntity dummyEntity = new DummyEntity("value");
        DummyEntity dummyEntity2 = dummyService.save(dummyEntity);
        dummyService.deleteById(dummyEntity2.id);
        assertFalse(dummyService.existsById(dummyEntity.id));
    }
    @Test
    void removeEntityThatDoesNotExist() {
        assertThrows(ResponseStatusException.class, () -> dummyService.deleteById(9000));
    }
    @Test
    void getAllEntities() {
        List<DummyEntity> entities = List.of(new DummyEntity("value1"), new DummyEntity("value2"), new DummyEntity("value3"));
        dummyService.save(entities.get(0));
        dummyService.save(entities.get(1));
        dummyService.save(entities.get(2));
        List<DummyEntity> entities2 = dummyService.getAll();
        assertIterableEquals(entities.stream().map(x -> x.field).toList(), entities2.stream().map(x -> x.field).toList());
    }
    @Test
    void retainOrderOfSaving() {
        List<DummyEntity> entities = List.of(new DummyEntity("value1"), new DummyEntity("value2"), new DummyEntity("value3"));
        dummyService.save(entities.get(2));
        dummyService.save(entities.get(0));
        dummyService.save(entities.get(1));
        entities = List.of(entities.get(2), entities.get(0), entities.get(1));
        List<DummyEntity> entities2 = dummyService.getAll();
        assertIterableEquals(entities.stream().map(x -> x.field).toList(), entities2.stream().map(x -> x.field).toList());
    }
}
