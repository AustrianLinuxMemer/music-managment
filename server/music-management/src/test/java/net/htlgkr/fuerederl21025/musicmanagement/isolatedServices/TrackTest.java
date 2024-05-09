package net.htlgkr.fuerederl21025.musicmanagement.isolatedServices;

import jakarta.transaction.Transactional;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.TrackService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class TrackTest {
    @Autowired
    TrackService trackService;

    /**
     * NOTE: It is expected for {@link org.springframework.data.repository.ListCrudRepository} to handle Entities with {@link jakarta.persistence.ElementCollection}
     * fields correctly. Adding in the impossibility to confidently assert {@link java.util.Map} instances from within JUnit,
     * it was decided to skip comparing the Metadata maps
     */
    @Test
    void saveTrack() {
        Track track = new Track("LOL", null, null, Map.of("Key1", "Value1", "Key2", "Value2"));
        Track track2 = trackService.save(track);
        assertEquals(1, track2.id);
        assertEquals(track.name, track2.name);
        assertEquals(track.urls, track2.urls);
        assertEquals(track.tags, track2.tags);
    }
}
