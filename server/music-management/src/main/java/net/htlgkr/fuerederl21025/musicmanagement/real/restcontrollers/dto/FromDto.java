package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers.dto;

/**
 * This is an interface to facilitate easy conversion of DTOs into their corresponding Entity objects
 * @param <T>
 */
public interface FromDto<T> {
    T fromDtoWithoutID();
    T fromDTOWithID();
}
