package net.htlgkr.fuerederl21025.musicmanagment.services;

import net.htlgkr.fuerederl21025.musicmanagment.entities.MIME;
import net.htlgkr.fuerederl21025.musicmanagment.repositories.MIMERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MIMEService {
    @Autowired
    private MIMERepository mimeRepository;
    public MIME addMime(MIME mime) {
        return mimeRepository.save(mime);
    }
    public Optional<MIME> getMimeById(int id) {
        return mimeRepository.findById(id);
    }
    public void deleteMime(MIME mime) {
        mimeRepository.delete(mime);
    }
    public Optional<MIME> getMimeMatching(String mime) {
        return mimeRepository.findMIMEMatching(mime);
    }
}
