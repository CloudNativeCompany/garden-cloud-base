package org.cnc.garden.cloud.example.feignclient;

import org.cnc.garden.cloud.common.result.Response;
import org.cnc.garden.cloud.example.feignclient.dto.UserRegistryRequest;
import org.cnc.garden.cloud.example.feignclient.dto.UserRegistryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * org.cnc.garden.cloud.example.feignclient - ExampleService
 *
 * @author tony-is-coding
 * @date 2022/6/6 21:15
 */
@FeignClient(name = "example-service", url = "http://127.0.0.1:8080/")
public interface ExampleService {

    @GetMapping("example/registry")
    Response<UserRegistryResponse> registry(@RequestBody UserRegistryRequest request);
}
