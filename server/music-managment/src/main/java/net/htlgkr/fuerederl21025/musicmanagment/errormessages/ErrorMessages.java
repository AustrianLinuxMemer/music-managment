package net.htlgkr.fuerederl21025.musicmanagment.errormessages;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Mime;

public class ErrorMessages {
    public static final String ALREADY_EXISTS_MESSAGE = "This value already exists";
    public static final String NULL_REQUEST_MESSAGE = "An Entity is expected for this request";
    public static final String INVALID_MIME_MESSAGE = "The provided Multipurpose Media Extension string violates the Regex: " + Mime.MIME_REGEX;
    public static final String DOES_NOT_EXIST_MESSAGE = "The Entity requested does not exist";
    public static final String NULL_VALUE_MESSAGE = "A Value is expected for this request";
}
