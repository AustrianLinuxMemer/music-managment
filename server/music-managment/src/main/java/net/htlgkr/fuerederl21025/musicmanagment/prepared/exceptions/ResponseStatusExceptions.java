package net.htlgkr.fuerederl21025.musicmanagment.prepared.exceptions;

import net.htlgkr.fuerederl21025.musicmanagment.prepared.errormessages.ErrorMessages;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.Function;
import java.util.function.Supplier;

public enum ResponseStatusExceptions implements Supplier<ResponseStatusException> {
    ALREADY_EXISTS {
        @Override

        public ResponseStatusException get() {
            return new ResponseStatusException(HttpStatusCode.valueOf(400), ErrorMessages.ALREADY_EXISTS_MESSAGE.toString());
        }
    },
    NULL_REQUEST_BODY {
        @Override
        public ResponseStatusException get() {
            return new ResponseStatusException(HttpStatusCode.valueOf(400), ErrorMessages.NULL_REQUEST_BODY_MESSAGE.toString());
        }
    },
    INVALID_MIME{
        @Override
        public ResponseStatusException get() {
            return new ResponseStatusException(HttpStatusCode.valueOf(400), ErrorMessages.INVALID_MIME_MESSAGE.toString());

        }
    },
    NOT_FOUND {
        @Override
        public ResponseStatusException get() {
            return new ResponseStatusException(HttpStatusCode.valueOf(404), ErrorMessages.DOES_NOT_EXIST_MESSAGE.toString());
        }
    },
    NULL_VALUE {
        @Override
        public ResponseStatusException get() {
            return new ResponseStatusException(HttpStatusCode.valueOf(400), ErrorMessages.NULL_VALUE_MESSAGE.toString());
        }
    }
}
