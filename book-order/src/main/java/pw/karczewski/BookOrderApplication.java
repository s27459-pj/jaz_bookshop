package pw.karczewski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class BookOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookOrderApplication.class, args);
    }
}
