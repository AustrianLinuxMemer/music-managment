package net.htlgkr.fuerederl21025.musicmanagement.stateless.utilities;


import net.htlgkr.fuerederl21025.musicmanagement.stateful.entities.Mime;

import java.util.function.Predicate;

public class MimeValidationUtility {
    public static final Predicate<Mime> OTHER_PUT_REQUIREMENTS = mime -> (mime.getName() != null && mime.getTrack() != null);
    public static final String MIME_REGEX = "[^/+]+/[^/]*";
    public static final Predicate<Mime> MATCHES_MIME_REGEX_STRING = mime -> mime.getName().matches(MIME_REGEX);
    public static final Predicate<String> MATCHES_MIME_REGEX = string -> string.matches(MIME_REGEX);
    public static final Predicate<Mime> PUT_REQUIREMENTS = MATCHES_MIME_REGEX_STRING.and(OTHER_PUT_REQUIREMENTS);
}
