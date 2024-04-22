package net.htlgkr.fuerederl21025.musicmanagement;

import net.htlgkr.fuerederl21025.musicmanagement.stateless.utilities.MimeValidationUtility;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MimeValidationTests {
    @Test
    void doesMimeCheckRecognizeMimesInIanaList() {
        //Read the File
        try (Stream<String> stream = Files.lines(Path.of("./mimes/all.csv")).skip(1)) {
            stream.map(x -> {
                //CSV format:
                //Name,Template,Reference
                String[] splinter = x.split(",");
                if (splinter[1].isEmpty() || splinter[1].equals("Template")) splinter[1] = "that/better+works";
                return splinter[1];
            }).forEach(string -> {
                System.out.println(string);
                assertTrue(MimeValidationUtility.MATCHES_MIME_REGEX.test(string));
            });
        } catch (IOException e) {
            assert false;
        }
    }
    @Test
    void doesMimeCheckRecognizeInvalidMimes() {
        List<String> notMimesAtAll = List.of("words", "words+words", "jdiji", "339js//+");
        notMimesAtAll.forEach(string -> {
            System.out.println(string);
            assertFalse(MimeValidationUtility.MATCHES_MIME_REGEX.test(string));
        });
    }
}
