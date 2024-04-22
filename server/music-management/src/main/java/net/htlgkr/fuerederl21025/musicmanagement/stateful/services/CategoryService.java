package net.htlgkr.fuerederl21025.musicmanagement.stateful.services;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import net.htlgkr.fuerederl21025.musicmanagement.stateful.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagement.stateful.repositories.CategoryRepository;
import net.htlgkr.fuerederl21025.musicmanagement.stateless.templates.CrudServiceTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements CrudServiceTemplate<Category, Category, Integer> {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category create(Category input) {
        if (!categoryRepository.existsById(input.getId())) throw new EntityExistsException();
        return categoryRepository.save(input);
    }

    @Override
    public Category findById(Integer integer) {
        if (categoryRepository.findById(integer).isEmpty()) throw new EntityNotFoundException();
        return categoryRepository.findById(integer).get();
    }

    @Override
    public Category update(Integer integer, Category input) {
        if (!categoryRepository.existsById(integer)) throw new EntityNotFoundException();
        Category old = categoryRepository.findById(integer).orElseThrow(EntityNotFoundException::new);
        if (old == null) throw new EntityNotFoundException();
        old.setTracks(input.getTracks());
        old.setName(input.getName());
        old.setCustomMetadata(input.getCustomMetadata());
        return categoryRepository.save(old);
    }

    @Override
    public Category delete(Integer integer) {
        if (!categoryRepository.existsById(integer)) throw new EntityNotFoundException();
        Category old = categoryRepository.findById(integer).orElseThrow(EntityNotFoundException::new);
        categoryRepository.deleteById(integer);
        return old;
    }

    @Override
    public boolean existsById(Integer integer) {
        return categoryRepository.existsById(integer);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findAllByIds(List<Integer> integers) {
        return categoryRepository.findAllById(integers);
    }
    public Category findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name).orElseThrow(EntityExistsException::new);
    }
}
