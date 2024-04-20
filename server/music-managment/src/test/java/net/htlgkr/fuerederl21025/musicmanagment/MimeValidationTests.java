package net.htlgkr.fuerederl21025.musicmanagment;

import net.htlgkr.fuerederl21025.musicmanagment.entities.Mime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
				assertTrue(Mime.isValidMimeString(string));
			});
		} catch (IOException e) {
            assert false;
        }
	}
	@Test
	void doesMimeCheckRecognizeInvalidMimes() {
		List<String> notMimesAtAll = List.of("words", "words+words", "jdiji", "339js//+");
		notMimesAtAll.stream().forEach(string -> {
			System.out.println(string);
			assertFalse(Mime.isValidMimeString(string));
		});
	}
}
