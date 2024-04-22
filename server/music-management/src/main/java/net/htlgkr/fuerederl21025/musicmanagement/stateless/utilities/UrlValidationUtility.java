package net.htlgkr.fuerederl21025.musicmanagement.stateless.utilities;

import net.htlgkr.fuerederl21025.musicmanagement.stateful.entities.Url;

import java.util.function.Predicate;

public class UrlValidationUtility {
    public static final Predicate<Url> PUT_REQUIREMENTS = url -> (url.getTrack() != null && url.getMime() != null && url.getCustomMetadata() != null && url.getUriTo() != null);
}
