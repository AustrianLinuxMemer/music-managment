package net.htlgkr.fuerederl21025.musicmanagment.services;

import net.htlgkr.fuerederl21025.musicmanagment.entities.MIME;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.entities.URL;
import net.htlgkr.fuerederl21025.musicmanagment.repositories.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class URLService {
    @Autowired
    private URLRepository urlRepository;
    public URL addUrl(URL url) {
        if (url == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return urlRepository.save(url);
    }
    public URL getUrlById(int id) {
        URL toGet = urlRepository.findById(id).orElse(null);
        if (toGet == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return toGet;
    }
    public void deleteUrl(URL url) {
        if (url == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        urlRepository.delete(url);
    }
    public List<URL> getUrlsUsingMimeType(MIME mime) {
        if (mime == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return urlRepository.findAllURLsUsingMimeType(mime);
    }
    public List<URL> getUrlsAssociatedWithTrack(Track track) {
        if (track == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return urlRepository.findAllURLsAssociatedWithTrack(track);
    }
}
