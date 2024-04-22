package net.htlgkr.fuerederl21025.musicmanagement.stateful.dtos;

import net.htlgkr.fuerederl21025.musicmanagement.stateful.entities.Track;
import net.htlgkr.fuerederl21025.musicmanagement.stateless.utilities.interfaces.Converter;

public record TrackDto() implements Converter<Track, TrackDto> {
    @Override
    public TrackDto convertFrom(Track object) {
        return null;
    }

    @Override
    public Track convertTo(TrackDto dto) {
        return null;
    }
}
