package net.htlgkr.fuerederl21025.musicmanagement.concreteServices;

import jakarta.transaction.Transactional;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.TrackService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class TrackServiceTest {
    @Autowired
    TrackService trackService;
    final List<String> listOfStrings = List.of("tag1", "tag2", "tag3");
    final List<Track> tracksWithTags = List.of(
            Track.makeNewTrack("Track1", null,Set.of(listOfStrings.get(1), listOfStrings.get(2)), null),
            Track.makeNewTrack("Track2", null, Set.of(listOfStrings.get(0), listOfStrings.get(2)), null),
            Track.makeNewTrack("Track3", null, Set.of(listOfStrings.get(0), listOfStrings.get(1)), null)
    );
    @Test
    void getAllTracksHavingOneTag() {
        Set<Track> withTagToTest = Set.of(trackService.save(tracksWithTags.get(0)), trackService.save(tracksWithTags.get(1)));
        trackService.save(tracksWithTags.get(2));
        Set<Track> trackSet = new HashSet<>(trackService.getAllTracksWithTag(listOfStrings.get(2)));
        assertEquals(withTagToTest, trackSet);
    }
    @Test
    void getAllTracksHavingMultipleTags() {
        trackService.save(tracksWithTags.get(0));
        Set<Track> withTagToTest = Set.of(trackService.save(tracksWithTags.get(1)));
        Set<Track> trackSet = new HashSet<>(trackService.getAllTracksWithTags(Set.of(listOfStrings.get(0), listOfStrings.get(2))));
        assertEquals(withTagToTest, trackSet);
    }
}
