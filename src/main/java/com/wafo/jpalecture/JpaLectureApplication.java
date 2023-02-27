package com.wafo.jpalecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaLectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaLectureApplication.class, args);
    }

}
