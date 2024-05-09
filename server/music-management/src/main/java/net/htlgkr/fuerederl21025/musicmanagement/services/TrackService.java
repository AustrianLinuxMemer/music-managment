package net.htlgkr.fuerederl21025.musicmanagement.services;

import net.htlgkr.fuerederl21025.musicmanagement.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService {
    @Autowired
    TrackRepository trackRepository;
    public Track addTrack(Track track) {
        return trackRepository.save(track);
    }
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    public Track getTrackById(int id) {
        Optional<Track> maybeTrack = trackRepository.findById(id);
        if (maybeTrack.isEmpty()) throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        return maybeTrack.get();
    }
    public Track deleteTrack(int id) {
        Track maybeTrack = getTrackById(id);
        trackRepository.deleteById(maybeTrack.getId());
        return maybeTrack;
    }
}
