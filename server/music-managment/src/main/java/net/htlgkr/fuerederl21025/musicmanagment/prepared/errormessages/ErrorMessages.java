package net.htlgkr.fuerederl21025.musicmanagment.prepared.errormessages;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Mime;

import java.util.function.Function;

public enum ErrorMessages {
    ALREADY_EXISTS_MESSAGE {
        private static final String message = "This Entity already exists";

        @Override
        public String toString() {
            return message;
        }
    },
    NULL_REQUEST_BODY_MESSAGE {
        private static final String message = "No Request Body Provided";

        @Override
        public String toString() {
            return message;
        }
    },
    INVALID_MIME_MESSAGE {
        private static final String message = "The provided Multipurpose Media Extension string violates the Regex: " + Mime.MIME_REGEX;;

        @Override
        public String toString() {
            return message;
        }
    },
    DOES_NOT_EXIST_MESSAGE {
        private static final String message = "The Entity requested does not exist";
        @Override
        public String toString() {
            return message;
        }
    },
    NULL_VALUE_MESSAGE {
        private static final String message = "Values are expected for this request";

        @Override
        public String toString() {
            return message;
        }
    };
}
