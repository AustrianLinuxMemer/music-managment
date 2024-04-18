package net.htlgkr.fuerederl21025.musicmanagment.services;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService {
    @Autowired
    private TrackRepository trackRepository;
    public Track addTrack(Track track) {
        if (track == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return trackRepository.save(track);
    }
    public Track getTrackById(int id) {
        Track toGet = trackRepository.findById(id).orElse(null);
        if (toGet == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        return toGet;
    }
    public void deleteTrack(Track track) {
        if (track == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        trackRepository.delete(track);
    }
    public List<Track> getAllTracksNamed(String name) {
        if (name == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return trackRepository.findAllTracksNamed(name);
    }
    public List<Track> getAllTracksBelongingTo(Category category) {
        if (category == null) throw new ResponseStatusException(HttpStatusCode.valueOf(400));
        return trackRepository.findAllTracksBelongingTo(category);
    }
}
