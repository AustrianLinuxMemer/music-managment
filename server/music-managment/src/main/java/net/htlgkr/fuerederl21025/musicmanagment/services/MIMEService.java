package net.htlgkr.fuerederl21025.musicmanagment.services;

import net.htlgkr.fuerederl21025.musicmanagment.entities.MIME;
import net.htlgkr.fuerederl21025.musicmanagment.repositories.MIMERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Service
public class MIMEService {
    @Autowired
    private MIMERepository mimeRepository;
    public MIME addMime(MIME mime) {
        if (mime == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return mimeRepository.save(mime);
    }
    public MIME getMimeById(int id) {
        MIME toGet = mimeRepository.findById(id).orElse(null);
        if (toGet == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        return toGet;
    }
    public void deleteMime(MIME mime) {
        if (mime == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        mimeRepository.delete(mime);
    }
    public MIME getMimeMatching(String mime) {
        if (mime == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        MIME toTest = mimeRepository.findMIMEMatching(mime).orElse(null);
        if (toTest == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        return toTest;
    }
}
