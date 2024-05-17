package net.htlgkr.fuerederl21025.musicmanagement.dummy.dummyEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;

/**
 * This class is a simple testing entity for testing purposes
 * It is the least something you can test an {@link AbstractCrudService} on. It is not supposed to be used in production at all
 * ONLY FOR TESTING PURPOSES!
 *
 * @author Leo Füreder
 * @version C.D.
 */

@Entity
public class DummyEntity {
    @Id
    @GeneratedValue
    public Integer id;
    public String field;

    public DummyEntity(Integer id, String field) {
        this.id = id;
        this.field = field;
    }

    public DummyEntity(String field) {
        this.field = field;
    }

    public DummyEntity() {
    }
}
