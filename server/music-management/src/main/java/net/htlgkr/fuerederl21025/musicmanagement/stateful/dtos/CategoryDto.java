package net.htlgkr.fuerederl21025.musicmanagement.stateful.dtos;

import net.htlgkr.fuerederl21025.musicmanagement.stateful.entities.Category;
import net.htlgkr.fuerederl21025.musicmanagement.stateless.utilities.interfaces.Converter;

public record CategoryDto() implements Converter<Category, CategoryDto> {
    @Override
    public CategoryDto convertFrom(Category object) {
        return null;
    }

    @Override
    public Category convertTo(CategoryDto dto) {
        return null;
    }
}
