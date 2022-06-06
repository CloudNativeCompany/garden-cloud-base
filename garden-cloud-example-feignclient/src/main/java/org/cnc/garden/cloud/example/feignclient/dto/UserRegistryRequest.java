package org.cnc.garden.cloud.example.feignclient.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * org.cnc.garden.cloud.example.dto - UserRegistry
 *
 * @author tony-is-coding
 * @date 2022/6/5 15:16
 */
@Data
@ApiModel(value = "用户注册请求")
public class UserRegistryRequest {
    @ApiModelProperty(value = "用户名称")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "注册时间")
    private LocalDateTime registryTime;


    public static UserRegistryRequest random() {
        UserRegistryRequest req = new UserRegistryRequest();
        req.username = "tony";
        req.password = "123123123123";
        req.registryTime = LocalDateTime.now();
        return req;
    }
}
