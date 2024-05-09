package net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.lang.NonNull;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
public abstract class AbstractCrudService<T, ID, R extends ListCrudRepository<T, ID>> {
    @Autowired
    protected R listCrudRepository;
    public T save(@NonNull T item) {
        return listCrudRepository.save(item);
    }
    public abstract T update(T newItem, ID id);
    public List<T> getAll() {
        return listCrudRepository.findAll();
    }
    public T getById(@NonNull ID id) {
        T maybeItem = listCrudRepository.findById(id).orElse(null);
        if (maybeItem == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        return maybeItem;
    }
    public T deleteById(@NonNull ID id) {
        T item = getById(id);
        listCrudRepository.deleteById(id);
        return item;
    }
}
