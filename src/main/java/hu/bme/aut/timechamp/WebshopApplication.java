package hu.bme.aut.timechamp;

import hu.bme.aut.timechamp.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WebshopApplication implements CommandLineRunner {

    @Autowired
    SampleService sampleService;

    public static void main(String[] args) {
        SpringApplication.run(WebshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sampleService.sampleMethod();
    }
}