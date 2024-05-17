package net.htlgkr.fuerederl21025.musicmanagement.relations;

import jakarta.transaction.Transactional;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Tag;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.URL;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.TagService;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.TrackService;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.URLService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This test tests all use-cases that the author can think of that might appear, these are only sunshine tests to confirm
 * that the functionality works as expected in the face of "normal" data
 */

@SpringBootTest
@Transactional
@Rollback
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class TheBigOneTest {
    @Autowired
    TagService tagService;
    @Autowired
    TrackService trackService;
    @Autowired
    URLService urlService;

    //Demo-Daten
    final List<String> tagNames = List.of("rock", "pop", "vaporwave", "future funk", "mallsoft");
    final List<String> trackNames = List.of("track1", "track2", "track3", "track4", "track5");
    final List<String> mimes = List.of("audio/flac", "audio/mp3", "audio/ogg");
    final List<String> urls = List.of("https://example.com/file.flac", "https://example.com/file.mp3", "https://example.com/file.ogg");

    @Test
    void addTrackWithAllDependencies() {
        Tag tag = new Tag();
        tag.setId(tagNames.get(2));
        Tag subTag1 = new Tag();
        subTag1.setId(tagNames.get(3));
        Tag subTag2 = new Tag();
        subTag2.setId(tagNames.get(4));
        tag.setSubTags(new HashSet<>(Set.of(subTag1, subTag2)));
        Tag savedTag = tagService.save(tag);
        Tag tag1 = new Tag();
        tag1.setId(tagNames.get(0));
        Tag tag2 = new Tag();
        tag2.setId(tagNames.get(1));
        Tag savedTag1 = tagService.save(tag1);
        Tag savedTag2 = tagService.save(tag2);
        assertEquals(tag1.getId(), savedTag1.getId());
        assertEquals(tag2.getId(), savedTag2.getId());
        assertEquals(tag.getId(), savedTag.getId());
        URL url = new URL();
        url.setMime(mimes.get(0));
        url.setUrl(urls.get(0));
        URL savedURL = urlService.save(url);
        URL url1 = new URL();
        url1.setMime(mimes.get(1));
        url1.setUrl(mimes.get(1));
        URL savedURL1 = urlService.save(url1);
        assertEquals(url.getId(), savedURL.getId());
        assertEquals(url1.getId(), savedURL1.getId());
        Track track = new Track();
        track.setUrls(new HashSet<>(Set.of(savedURL, savedURL1)));
        track.setTags(new HashSet<>(Set.of(savedTag, savedTag1, savedTag2)));
        track.setName(trackNames.get(2));
        Track savedTrack = trackService.save(track);
        assertEquals(track.getId(), savedTrack.getId());
    }
}
