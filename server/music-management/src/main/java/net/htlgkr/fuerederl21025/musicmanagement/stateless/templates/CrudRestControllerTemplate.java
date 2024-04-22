package net.htlgkr.fuerederl21025.musicmanagement.stateless.templates;

import java.util.List;

public interface CrudRestControllerTemplate<IN, OUT, ID> {
    OUT post(IN input);
    OUT put(ID id, IN input);
    OUT get(ID id);
    OUT delete(ID id);
    List<OUT> getAll();
    List<OUT> getAllThatCorrespondToIds(List<ID> ids);
}
