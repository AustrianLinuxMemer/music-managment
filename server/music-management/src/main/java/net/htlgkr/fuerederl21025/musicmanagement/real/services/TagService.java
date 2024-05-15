package net.htlgkr.fuerederl21025.musicmanagement.real.services;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Tag;
import net.htlgkr.fuerederl21025.musicmanagement.real.repositories.TagRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TagService extends AbstractCrudService<Tag, String, TagRepository> {
    @Override
    public Tag edit(Tag item, String s) {
        if (item == null || s == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        Tag oldTag = getById(s);
        oldTag.tracks = item.tracks;
        oldTag.metadata = item.metadata;
        return save(oldTag);
    }
}
