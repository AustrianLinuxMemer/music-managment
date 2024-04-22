package net.htlgkr.fuerederl21025.musicmanagement.stateless.templates;

import java.util.List;
import java.util.Optional;

public interface CrudServiceTemplate<IN, OUT, ID> {
    OUT create(IN input);
    OUT findById(ID id);
    OUT update(ID id, IN input);
    OUT delete(ID id);
    boolean existsById(ID id);
    List<OUT> findAll();
    List<OUT> findAllByIds(List<ID> ids);
}
