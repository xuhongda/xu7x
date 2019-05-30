package com.xu.xu7x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Xu7xWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(Xu7xWebApplication.class, args);
    }

}

