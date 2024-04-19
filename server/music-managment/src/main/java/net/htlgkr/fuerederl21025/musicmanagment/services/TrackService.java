package net.htlgkr.fuerederl21025.musicmanagment.services;

import jakarta.persistence.EntityNotFoundException;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.errormessages.ErrorMessages;
import net.htlgkr.fuerederl21025.musicmanagment.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TrackService {
    @Autowired
    private TrackRepository trackRepository;
    public Track createTrack(@NonNull Track track) {
        return trackRepository.save(track);
    }
    public Track saveTrack(@NonNull Track track) {
        return trackRepository.save(track);
    }
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }
    public List<Track> getAllTracksByIds(@NonNull List<Integer> trackIDs) {
        return trackRepository.findAllById(trackIDs);
    }
    public Track getTrackById(int id) {
        if (trackRepository.findById(id).isEmpty()) throw new EntityNotFoundException();
        return trackRepository.findById(id).get();
    }
    public void deleteTrack(int id) {
        trackRepository.deleteById(id);
    }
    public List<Track> getAllTracksNamedLike(@NonNull String name) {
        return trackRepository.findByNameLike(name);
    }
    public List<Track> getAllTracksBelongingTo(@NonNull Category category) {
        return trackRepository.findByCategories(category);
    }
}
