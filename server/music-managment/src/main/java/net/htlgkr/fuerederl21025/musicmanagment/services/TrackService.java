package net.htlgkr.fuerederl21025.musicmanagment.services;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagment.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService {
    @Autowired
    private TrackRepository trackRepository;
    public Track addTrack(Track track) {
        return trackRepository.save(track);
    }
    public Optional<Track> getTrackById(int id) {
        return trackRepository.findById(id);
    }
    public void deleteTrack(Track track) {
        trackRepository.delete(track);
    }
    public List<Track> getAllTracksNamed(String name) {
        return trackRepository.findAllTracksNamed(name);
    }
    public List<Track> getAllTracksBelongingTo(Category category) {
        return trackRepository.findAllTracksBelongingTo(category);
    }
}
