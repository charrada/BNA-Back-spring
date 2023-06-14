package bna.projet;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


////@EnableAutoConfiguration
//@EnableAspectJAutoProxy

//
//
//
//@EnableScheduling
//@EnableBatchProcessing
//@SpringBootApplication

@EnableBatchProcessing
@EnableScheduling
@SpringBootApplication
public class BnaApplication {
    // private static String userDirectory = System.getProperty("user.dir");
    public static void main(String[] args) {
        SpringApplication.run(BnaApplication.class, args);
//        int i=0;
//        String filename="result.csv";
//        Path pathToFile = Paths.get(filename);
//        System.out.println(pathToFile.toAbsolutePath());
//        System.out.println("******************"+userDirectory);

    }


}
