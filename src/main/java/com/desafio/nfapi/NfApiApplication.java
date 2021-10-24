package com.desafio.nfapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NfApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NfApiApplication.class, args);

    }

}
