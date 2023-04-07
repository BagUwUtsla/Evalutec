package fr.solutec.evalutec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EvalutecApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EvalutecApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("done");
    }
}
