package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractRestController.AbstractCrudRestController;
import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers.dtos.TrackDto;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.TagService;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.TrackService;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.URLService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class TrackRestController extends AbstractCrudRestController<Track, Integer, TrackService> {
    @Autowired
    TagService tagService;
    @Autowired
    URLService urlService;
}
