package net.htlgkr.fuerederl21025.musicmanagment.services;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.errormessages.ErrorMessages;
import net.htlgkr.fuerederl21025.musicmanagment.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TrackService {
    @Autowired
    private TrackRepository trackRepository;
    public Track saveTrack(Track track) {
        if (track == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400), ErrorMessages.NULL_REQUEST_MESSAGE);
        return trackRepository.save(track);
    }
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }
    public List<Track> getAllTracksByIds(List<Integer> trackIDs) {
        return trackRepository.findAllById(trackIDs);
    }
    public Track getTrackById(int id) {
        Track toGet = trackRepository.findById(id).orElse(null);
        if (toGet == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404), ErrorMessages.DOES_NOT_EXIST_MESSAGE);
        return toGet;
    }
    public void deleteTrack(int id) {
        trackRepository.deleteById(id);
    }
    public List<Track> getAllTracksNamedLike(String name) {
        if (name == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400), ErrorMessages.NULL_VALUE_MESSAGE);
        return trackRepository.findByNameLike(name);
    }
    public List<Track> getAllTracksBelongingTo(Category category) {
        if (category == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400), ErrorMessages.NULL_VALUE_MESSAGE);
        return trackRepository.findByCategories(category);
    }
}
