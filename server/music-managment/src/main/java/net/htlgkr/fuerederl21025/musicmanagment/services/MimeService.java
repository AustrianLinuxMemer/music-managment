package net.htlgkr.fuerederl21025.musicmanagment.services;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Mime;
import net.htlgkr.fuerederl21025.musicmanagment.repositories.MimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MimeService {
    @Autowired
    private MimeRepository mimeRepository;
    public Mime saveMime(Mime mime) {
        if (mime == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return mimeRepository.save(mime);
    }
    public Mime getMimeById(int id) {
        Mime toGet = mimeRepository.findById(id).orElse(null);
        if (toGet == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        return toGet;
    }
    public void deleteMimeById(int id) {
        mimeRepository.deleteById(id);
    }
    public Mime getMimeMatching(String mime) {
        if (mime == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        Mime toTest = mimeRepository.findByMime(mime).orElse(null);
        if (toTest == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        return toTest;
    }
    public List<Mime> getAllMime() {
        return mimeRepository.findAll();
    }
}
