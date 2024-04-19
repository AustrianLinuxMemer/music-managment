package net.htlgkr.fuerederl21025.musicmanagment.services;

import jakarta.persistence.EntityNotFoundException;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Mime;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Url;
import net.htlgkr.fuerederl21025.musicmanagment.errormessages.ErrorMessages;
import net.htlgkr.fuerederl21025.musicmanagment.repositories.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UrlService {
    @Autowired
    private URLRepository urlRepository;
    public Url saveUrl(@NonNull Url url) {
        if (url.getUrlTo() == null) throw new IllegalArgumentException();
        return urlRepository.save(url);
    }
    public Url getUrlById(int id) {
        if (urlRepository.findById(id).isEmpty()) throw new EntityNotFoundException();
        return urlRepository.findById(id).get();
    }
    public void deleteUrl(int id) {
        urlRepository.deleteById(id);
    }
    public List<Url> getAllUrls() {
        return urlRepository.findAll();
    }
    public List<Url> getUrlsUsingMimeType(@NonNull Mime mime) {
        return urlRepository.findByMime(mime);
    }
    public List<Url> getUrlsAssociatedWithTrack(@NonNull Track track) {
        return urlRepository.findByTrack(track);
    }
    public List<Url> getUrlsAssociatedWithTrackAndUsingMime(@NonNull Track track, @NonNull Mime mime) {
        return urlRepository.findByTrackAndMime(track, mime);
    }
}
