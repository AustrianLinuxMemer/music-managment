package net.htlgkr.fuerederl21025.musicmanagment;

import net.htlgkr.fuerederl21025.musicmanagment.services.CategoryService;
import net.htlgkr.fuerederl21025.musicmanagment.services.MimeService;
import net.htlgkr.fuerederl21025.musicmanagment.services.TrackService;
import net.htlgkr.fuerederl21025.musicmanagment.services.UrlService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MusicManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicManagementApplication.class, args);
	}

	@Bean
	public UrlService urlService() {
		return new UrlService();
	}
	@Bean
	public CategoryService categoryService() {
		return new CategoryService();
	}
	@Bean
	public TrackService trackService() {
		return new TrackService();
	}
	@Bean
	public MimeService mimeService() {
		return new MimeService();
	}
}
