package net.htlgkr.fuerederl21025.musicmanagement.stateful.dtos;

import net.htlgkr.fuerederl21025.musicmanagement.stateful.entities.Mime;
import net.htlgkr.fuerederl21025.musicmanagement.stateless.utilities.interfaces.Converter;

public record MimeDto() implements Converter<Mime, MimeDto> {
    @Override
    public MimeDto convertFrom(Mime object) {
        return null;
    }

    @Override
    public Mime convertTo(MimeDto dto) {
        return null;
    }
}
