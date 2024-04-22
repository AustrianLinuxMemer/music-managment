package net.htlgkr.fuerederl21025.musicmanagement.stateless.utilities;

import net.htlgkr.fuerederl21025.musicmanagement.stateful.entities.Category;

import java.util.function.Predicate;

public class CategoryUtility {
    public static final Predicate<Category> PUT_REQUIREMENTS = category -> (category.getName() != null && category.getCustomMetadata() != null);
}
