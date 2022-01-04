package com.example.boardpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class BoardpageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardpageApplication.class, args);
    }

}
