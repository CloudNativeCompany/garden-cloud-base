package org.cnc.garden.cloud.example;

import org.cnc.garden.cloud.example.controller.ExampleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000));
        final int batchSize = 50;
        for (int i = 0; i < batchSize; i++) {
            executor.submit(() -> {
                controller.atomicAdd();
            });
        }
        Thread.sleep(5000);
        System.out.println(ExampleController.a);
    }
}
