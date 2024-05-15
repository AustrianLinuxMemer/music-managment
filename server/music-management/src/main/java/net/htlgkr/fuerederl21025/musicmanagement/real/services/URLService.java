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
    public URL save(@NonNull URL item) {
        if (!URL.isMime.test(item.mime)) throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Given Mime string does not match against the Mime regex");
        return super.save(item);
    }

    @Override
    public URL edit(URL item, Integer integer) {
        if (item == null || integer == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        if (!URL.isMime.test(item.mime)) throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Given Mime string does not match against the Mime regex");
        URL oldItem = getById(integer);
        oldItem.mime = item.mime;
        oldItem.url = item.url;
        oldItem.track = item.track;
        return save(oldItem);
    }

}
