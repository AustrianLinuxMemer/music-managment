package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers.dto;

/**
 * This is an interface to facilitate easy conversion of DTOs into their corresponding Entity objects
 * @param <T> The Entity class used
 */
public interface FromDto<T> {
    /**
     * This method generates an Entity object from a DTO that has it's <code>id</code> field omitted
     * @return An Entity object missing the <code>id</code> field of it's DTO
     */
    T fromDtoWithoutID();

    /**
     * This method generates an Entity object from a DTO that include it's <code>id</code> field
     * @return An Entity object with all fields of it's DTO
     */
    T fromDTOWithID();
}
