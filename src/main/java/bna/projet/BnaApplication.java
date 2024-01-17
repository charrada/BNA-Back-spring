package bna.projet;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableBatchProcessing
@EnableScheduling
@SpringBootApplication
public class BnaApplication {
    public static void main(String[] args) {
        SpringApplication.run(BnaApplication.class, args);

    }


}
