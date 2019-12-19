package sphy.images;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import sphy.images.storage.FileSystemStorageService;
import sphy.images.storage.StorageProperties;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ImagesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImagesApplication.class, args);
    }

    @Bean
    CommandLineRunner init(FileSystemStorageService storageService) {
        return (args) -> {
            storageService.init();
        };
    }
}
