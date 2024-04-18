package net.htlgkr.fuerederl21025.musicmanagment.services;

import net.htlgkr.fuerederl21025.musicmanagment.entities.MIME;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.entities.URL;
import net.htlgkr.fuerederl21025.musicmanagment.repositories.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class URLService {
    @Autowired
    private URLRepository urlRepository;
    public URL addUrl(URL url) {
        return urlRepository.save(url);
    }
    public Optional<URL> getUrlById(int id) {
        return urlRepository.findById(id);
    }
    public void deleteUrl(URL url) {
        urlRepository.delete(url);
    }
    public List<URL> getUrlsUsingMimeType(MIME mime) {
        return urlRepository.findAllURLsUsingMimeType(mime);
    }
    public List<URL> getUrlsAssociatedWithTrack(Track track) {
        return urlRepository.findAllURLsAssociatedWithTrack(track);
    }
}
