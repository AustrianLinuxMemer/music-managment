package net.htlgkr.fuerederl21025.musicmanagement.real.entities;

import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractRestController.AbstractCrudRestController;
import net.htlgkr.fuerederl21025.musicmanagement.abstracts.abstractService.AbstractCrudService;

/**
 * The base for all other Entities that are managed by JPA, created to aid Services and RestControllers that extend
 * {@link AbstractCrudService} and {@link AbstractCrudRestController} respectively
 *
 * @param <ID> the type of ID that should be used
 *
 * @author Leo Füreder
 * @version C.D.
 */
public class BaseEntity<ID> {
    /**
     * The base ID field that is needed for JPA's persistence magic
     */
    public ID id;
}
