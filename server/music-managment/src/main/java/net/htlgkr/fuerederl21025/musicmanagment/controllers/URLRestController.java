package net.htlgkr.fuerederl21025.musicmanagment.controllers;

import net.htlgkr.fuerederl21025.musicmanagment.services.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/urls")
public class URLRestController {
    @Autowired
    private URLService urlService;
}
