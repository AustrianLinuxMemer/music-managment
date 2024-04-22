package net.htlgkr.fuerederl21025.musicmanagement.stateful.dtos;

import net.htlgkr.fuerederl21025.musicmanagement.stateful.entities.Url;
import net.htlgkr.fuerederl21025.musicmanagement.stateless.utilities.interfaces.Converter;

public record UrlDto() implements Converter<Url, UrlDto> {
    @Override
    public UrlDto convertFrom(Url object) {
        return null;
    }

    @Override
    public Url convertTo(UrlDto dto) {
        return null;
    }
}
