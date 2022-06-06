package org.cnc.garden.cloud.example.feignclient;

import org.cnc.garden.cloud.common.result.Response;
import org.cnc.garden.cloud.example.feignclient.dto.UserRegistryRequest;
import org.cnc.garden.cloud.example.feignclient.dto.UserRegistryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * org.cnc.garden.cloud.example.feignclient - SpringBootApplication
 *
 * @author tony-is-coding
 * @date 2022/6/6 21:10
 */
@EnableFeignClients
@SpringBootApplication
public class FeignClientApplication implements ApplicationRunner {

    public FeignClientApplication(ExampleService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignClientApplication.class, args);
    }

    final ExampleService service;

    @Override
    public void run(ApplicationArguments args) {
        Response<UserRegistryResponse> registry = service.registry(UserRegistryRequest.random());
        System.out.println(registry);
    }
}
