package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractRestController.AbstractCrudRestController;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.Tag;
import net.htlgkr.fuerederl21025.musicmanagement.real.entities.URL;
import net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers.dtos.TagDto;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.TagService;
import net.htlgkr.fuerederl21025.musicmanagement.real.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class TagRestController extends AbstractCrudRestController<Tag, String, TagService> {
}
