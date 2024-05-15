package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractRestController.AbstractCrudRestController;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;

public class TrackRestController extends AbstractCrudRestController<Track, Integer, TrackService> {
}
