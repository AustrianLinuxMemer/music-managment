package net.htlgkr.fuerederl21025.musicmanagment.controllers;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.post.MimePostDto;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.put.MimePutDto;
import net.htlgkr.fuerederl21025.musicmanagment.dtos.outgoing.response.MimeResponseDto;
import net.htlgkr.fuerederl21025.musicmanagment.entities.Mime;
import net.htlgkr.fuerederl21025.musicmanagment.prepared.exceptions.ResponseStatusExceptions;
import net.htlgkr.fuerederl21025.musicmanagment.services.MimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.InvalidMimeTypeException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/mimes")
public class MimeRestController {
    @Autowired
    private MimeService mimeService;
    @PostMapping("/")
    public MimeResponseDto createMime(@RequestBody MimePostDto mimePostDto) {
        if (mimePostDto == null) throw ResponseStatusExceptions.NULL_REQUEST_BODY.get();
        mimePostDto.accept(ResponseStatusExceptions.NULL_VALUE.get());
        Mime mime = new Mime();
        try {
            mime.setName(mimePostDto.name());
            return MimeResponseDto.generateMimeResponseDto(mimeService.createMime(mime));
        } catch (EntityExistsException e) {
            throw ResponseStatusExceptions.ALREADY_EXISTS.get();
        } catch (InvalidMimeTypeException e) {
            throw ResponseStatusExceptions.INVALID_MIME.get();
        }
    }
    @PutMapping("/{id}")
    public MimeResponseDto updateMimeDto(@PathVariable int id, @RequestBody MimePutDto mimePutDto) {
        if (mimePutDto == null) throw ResponseStatusExceptions.NULL_REQUEST_BODY.get();
        mimePutDto.accept(ResponseStatusExceptions.NULL_VALUE.get());
        try {
            Mime mime = mimeService.getMimeById(id);
            if (mime.getName().equals(mimePutDto.name())) throw new EntityExistsException();
            mime.setName(mimePutDto.name());
            return MimeResponseDto.generateMimeResponseDto(mimeService.saveMime(mime));
        } catch (EntityExistsException e) {
            throw ResponseStatusExceptions.ALREADY_EXISTS.get();
        } catch (EntityNotFoundException e) {
            throw ResponseStatusExceptions.NOT_FOUND.get();
        } catch (InvalidMimeTypeException e) {
            throw ResponseStatusExceptions.INVALID_MIME.get();
        }

    }
    @GetMapping("/{id}")
    public MimeResponseDto getMimeById(@PathVariable int id) {
        try {
            return MimeResponseDto.generateMimeResponseDto(mimeService.getMimeById(id));
        } catch (EntityNotFoundException e) {
            throw ResponseStatusExceptions.NOT_FOUND.get();
        }
    }
    @DeleteMapping("/{id}")
    public MimeResponseDto deleteMimeDto(@PathVariable int id) {
        try {
            Mime mime = mimeService.getMimeById(id);
            if (mime == null) throw ResponseStatusExceptions.NOT_FOUND.get();
            mimeService.deleteMimeById(id);
            return MimeResponseDto.generateMimeResponseDto(mime);
        } catch (EntityNotFoundException e) {
            throw ResponseStatusExceptions.NOT_FOUND.get();
        }
    }
    @GetMapping("/search")
    public MimeResponseDto getMimeByName(@RequestParam String mime) {
        if (mime == null) throw ResponseStatusExceptions.NULL_VALUE.get();
        try {
            return MimeResponseDto.generateMimeResponseDto(mimeService.getMimeMatching(mime));
        } catch (EntityNotFoundException e){
            throw ResponseStatusExceptions.NOT_FOUND.get();
        }
    }
    @GetMapping("/")
    public List<MimeResponseDto> getAllMimes() {
        return mimeService.getAllMime().stream().map(MimeResponseDto::generateMimeResponseDto).toList();
    }

}
