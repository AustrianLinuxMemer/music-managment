package net.htlgkr.fuerederl21025.musicmanagment.controllers;

import net.htlgkr.fuerederl21025.musicmanagment.dtos.UrlDto;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Url;
import net.htlgkr.fuerederl21025.musicmanagment.services.MimeService;
import net.htlgkr.fuerederl21025.musicmanagment.services.TrackService;
import net.htlgkr.fuerederl21025.musicmanagment.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/urls")
public class UrlRestController {
    @Autowired
    UrlService urlService;
    @Autowired
    MimeService mimeService;
    @Autowired
    TrackService trackService;
    @PostMapping("/")
    public UrlDto createUrl(@RequestBody UrlDto urlDto) {
        Url url = new Url();
        url.setUrlTo(urlDto.url());
        url.setMime(mimeService.getMimeById(urlDto.mime()));
        url.setTrack(trackService.getTrackById(urlDto.track()));
        url.setUrlTo(urlDto.url());
        return new UrlDto(urlService.saveUrl(url));
    }
    @PutMapping("/{id}")
    public UrlDto updateUrl(@PathVariable int id, @RequestBody UrlDto urlDto) {
        Url url = urlService.getUrlById(id);
        url.setUrlTo(urlDto.url());
        url.setMime(mimeService.getMimeById(urlDto.mime()));
        url.setTrack(trackService.getTrackById(urlDto.track()));
        url.setUrlTo(urlDto.url());
        return new UrlDto(urlService.saveUrl(url));
    }
    @GetMapping("/{id}")
    public UrlDto getUrl(@PathVariable int id) {
        return new UrlDto(urlService.getUrlById(id));
    }
    @DeleteMapping("/{id}")
    public UrlDto deleteUrl(@PathVariable int id) {
        UrlDto urlDto = new UrlDto(urlService.getUrlById(id));
        urlService.deleteUrl(id);
        return urlDto;
    }
    @GetMapping("/all")
    public List<UrlDto> getAllUrls(@RequestParam(required = false) Integer mimeId, @RequestParam(required = false) Integer trackId) {
        if (mimeId == null && trackId == null) {
            return urlService.getAllUrls().stream().map(UrlDto::new).toList();
        } else if (mimeId == null) {
            return urlService.getUrlsAssociatedWithTrack(trackService.getTrackById(trackId)).stream().map(UrlDto::new).toList();
        } else if (trackId == null) {
            return urlService.getUrlsUsingMimeType(mimeService.getMimeById(mimeId)).stream().map(UrlDto::new).toList();
        } else {
            return urlService.getUrlsAssociatedWithTrackAndUsingMime(trackService.getTrackById(trackId), mimeService.getMimeById(mimeId)).stream().map(UrlDto::new).toList();
        }
    }
}
