package edu.onimeboyz.palevobotapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Main {
    public static void main(String[] args) {
        startAPI(args);
    }

    private static void startAPI(String[] args){
        SpringApplication.run(Main.class, args);
    }
}
