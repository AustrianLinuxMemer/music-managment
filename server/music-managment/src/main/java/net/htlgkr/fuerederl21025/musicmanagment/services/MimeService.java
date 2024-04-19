package net.htlgkr.fuerederl21025.musicmanagment.services;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Mime;
import net.htlgkr.fuerederl21025.musicmanagment.errormessages.ErrorMessages;
import net.htlgkr.fuerederl21025.musicmanagment.repositories.MimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MimeService {
    @Autowired
    private MimeRepository mimeRepository;
    public Mime createMime(@NonNull Mime mime) {
        if (mime.getMime() == null) throw new IllegalArgumentException();
        if (mimeRepository.findByMime(mime.getMime()).isPresent()) throw new EntityExistsException();
        return mimeRepository.save(mime);
    }
    public Mime saveMime(@NonNull Mime mime) {
        if (mime.getMime() == null) throw new IllegalArgumentException();
        if (mimeRepository.findByMime(mime.getMime()).isPresent()) throw new EntityExistsException();
        return mimeRepository.save(mime);
    }
    public Mime getMimeById(int id) {
        if (mimeRepository.findById(id).isEmpty()) throw new EntityNotFoundException();
        return mimeRepository.findById(id).get();
    }
    public void deleteMimeById(int id) {
        mimeRepository.deleteById(id);
    }
    public Mime getMimeMatching(@NonNull String mime) {
        if (mimeRepository.findByMime(mime).isEmpty()) throw new EntityNotFoundException();
        return mimeRepository.findByMime(mime).get();
    }
    public List<Mime> getAllMime() {
        return mimeRepository.findAll();
    }
}
