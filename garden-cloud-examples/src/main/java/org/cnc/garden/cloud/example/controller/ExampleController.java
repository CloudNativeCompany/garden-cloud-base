package org.cnc.garden.cloud.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.cnc.garden.cloud.common.entity.UserInfo;
import org.cnc.garden.cloud.example.lock.DistributeLock;
import org.cnc.garden.cloud.web.annotation.User;
import org.cnc.garden.cloud.common.result.Response;
import org.cnc.garden.cloud.example.dto.UserRegistryRequest;
import org.cnc.garden.cloud.example.dto.UserRegistryResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * org.cnc.garden.cloud.example.controller - ExampleController
 *
 * @author tony-is-coding
 * @date 2022/6/5 15:15
 */
@Api(tags = "用户相关操作")
@RestController
@RequestMapping(value = "/example")
public class ExampleController {

    @ApiOperation(value = "用户注册", notes = "用户注册")
    @PostMapping(value = "/registry")
    public Response<UserRegistryResponse> registry(@RequestBody UserRegistryRequest request, @User UserInfo userInfo) {
        System.out.println(request);
        System.out.println(userInfo);
        System.out.println(a == 1000);
        return Response.data(lockAndCreate());
    }

    @DistributeLock(expireSecond = 5, name = "UserLock")
    public UserRegistryResponse lockAndCreate() {
        UserRegistryResponse resp = new UserRegistryResponse();
        resp.setToken(112738718923123981L);
        resp.setExpireAt(LocalDateTime.now());
        return resp;
    }

    public static long a = 0;

    @DistributeLock(expireSecond = 5, name = "addLock")
    public void atomicAdd() {
        a++;
    }

}

