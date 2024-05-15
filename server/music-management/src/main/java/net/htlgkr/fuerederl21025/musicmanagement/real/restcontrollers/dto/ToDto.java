package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers.dto;

public interface ToDto<DTO> {
    DTO toDtoWithoutID();
    DTO toDtoWithID();
}
