package net.htlgkr.fuerederl21025.musicmanagement.services;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.entities.Tag;
import net.htlgkr.fuerederl21025.musicmanagement.repositories.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService extends AbstractCrudService<Tag, Integer, TagRepository> {

    @Override
    public Tag update(Tag newItem, Integer integer) {
        return null;
    }
}
