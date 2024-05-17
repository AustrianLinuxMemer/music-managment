package net.htlgkr.fuerederl21025.musicmanagement.real.services;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.URL;
import net.htlgkr.fuerederl21025.musicmanagement.real.repositories.URLRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
public class URLService extends AbstractCrudService<URL, Integer, URLRepository> {
    @Override
    public URL replace(@NonNull URL item, @NonNull Integer integer) {
        if (item == null || integer == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        URL oldItem = getById(integer);
        oldItem.setUrl(item.getUrl());
        oldItem.setMetadata(item.getMetadata());
        oldItem.setMime(item.getMime());
        return save(oldItem);
    }
}
