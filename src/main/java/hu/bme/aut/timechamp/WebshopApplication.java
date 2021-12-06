package hu.bme.aut.timechamp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WebshopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        sampleDataService.addSampleData();
    }
}