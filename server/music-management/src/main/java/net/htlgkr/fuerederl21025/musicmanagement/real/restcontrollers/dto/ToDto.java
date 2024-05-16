package net.htlgkr.fuerederl21025.musicmanagement.real.restcontrollers.dto;

/**
 * This is an interface to facilitate easy conversion of Entities into their corresponding DTO objects
 * @param <DTO> The DTO class used
 */
public interface ToDto<DTO> {
    /**
     * This method generates a DTO object from an Entity that has it's <code>id</code> field omitted
     * @return A DTO object missing the <code>id</code> field of it's Entity
     */
    DTO toDtoWithoutID();
    /**
     * This method generates a DTO object from an Entity that include it's <code>id</code> field
     * @return A DTO object with all fields of it's Entity
     */
    DTO toDtoWithID();
}
