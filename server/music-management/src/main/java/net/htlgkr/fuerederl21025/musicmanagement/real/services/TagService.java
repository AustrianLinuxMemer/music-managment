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
    public Tag replace(@NonNull Tag item, @NonNull String s) {
        if (item == null || s == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        Tag oldItem = getById(s);
        oldItem.setMetadata(item.getMetadata());
        oldItem.setSubTags(item.getSubTags());
        oldItem.setSuperTag(item.getSuperTag());
        oldItem.setTracks(item.getTracks());
        return save(oldItem);
    }

    @Override
    public Tag save(Tag item) {
        item.setId(item.getId().toLowerCase());
        return super.save(item);
    }
}
