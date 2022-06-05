package org.cnc.garden.cloud.example.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
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
}
