package net.htlgkr.fuerederl21025.musicmanagment.services;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Mime;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Url;
import net.htlgkr.fuerederl21025.musicmanagment.repositories.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UrlService {
    @Autowired
    private URLRepository urlRepository;
    public Url saveUrl(Url url) {
        if (url == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return urlRepository.save(url);
    }
    public Url getUrlById(int id) {
        Url toGet = urlRepository.findById(id).orElse(null);
        if (toGet == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return toGet;
    }
    public void deleteUrl(int id) {
        urlRepository.deleteById(id);
    }
    public List<Url> getAllUrls() {
        return urlRepository.findAll();
    }
    public List<Url> getUrlsUsingMimeType(Mime mime) {
        if (mime == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return urlRepository.findByMime(mime);
    }
    public List<Url> getUrlsAssociatedWithTrack(Track track) {
        if (track == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return urlRepository.findByTrack(track);
    }
    public List<Url> getUrlsAssociatedWithTrackAndUsingMime(Track track, Mime mime) {
        if (track == null || mime == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return urlRepository.findByTrackAndMime(track, mime);
    }
}
