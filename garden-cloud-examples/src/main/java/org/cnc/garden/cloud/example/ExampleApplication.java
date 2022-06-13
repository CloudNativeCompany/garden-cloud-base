package org.cnc.garden.cloud.example;

import org.cnc.garden.cloud.example.controller.ExampleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * org.cnc.garden.cloud.example - ExamploeApplication
 *
 * @author tony-is-coding
 * @date 2022/6/5 15:14
 */
@SpringBootApplication
public class ExampleApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    @Autowired
    ExampleController controller;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        controller.lockAndCreate();
    }
}
