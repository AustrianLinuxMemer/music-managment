package net.htlgkr.fuerederl21025.musicmanagement.real.services;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.real.repositories.TrackRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class TrackService extends AbstractCrudService<Track, Integer, TrackRepository> {
    @Override
    public Track replace(@NonNull Track item, @NonNull Integer integer) {
        if (item == null || integer == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        Track oldItem = getById(integer);
        oldItem.setName(item.getName());
        oldItem.setTags(item.getTags());
        oldItem.setUrls(item.getUrls());
        oldItem.setMetadata(item.getMetadata());
        return save(oldItem);
    }
    //public List<Track> getAllTracksHaving
}
