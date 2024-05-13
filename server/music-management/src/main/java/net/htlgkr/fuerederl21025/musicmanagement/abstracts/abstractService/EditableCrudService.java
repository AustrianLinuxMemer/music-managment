package net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService;

import net.htlgkr.fuerederl21025.musicmanagement.real.entities.BaseEntity;
import org.springframework.lang.NonNull;

public interface EditableCrudService<T extends BaseEntity<ID>, ID> {
    T edit(@NonNull T newItem, @NonNull ID id);
}
