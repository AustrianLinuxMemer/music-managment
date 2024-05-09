package net.htlgkr.fuerederl21025.musicmanagement.services;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.entities.URL;
import net.htlgkr.fuerederl21025.musicmanagement.repositories.TrackRepository;
import net.htlgkr.fuerederl21025.musicmanagement.repositories.URLRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class URLService extends AbstractCrudService<URL, Integer, URLRepository> {
    @Override
    public URL update(@NonNull URL newItem, @NonNull Integer id) {
        if (!URL.isMime.test(newItem.mimeType())) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        deleteById(id);
        return listCrudRepository.save(new URL(id, newItem.url(), newItem.mimeType(), newItem.track()));
    }

    @Override
    public URL save(@NonNull URL item) {
        if (!URL.isMime.test(item.mimeType())) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return super.save(item);
    }

}
