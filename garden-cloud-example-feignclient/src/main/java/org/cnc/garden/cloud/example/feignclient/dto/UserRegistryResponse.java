package org.cnc.garden.cloud.example.feignclient.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * org.cnc.garden.cloud.example.dto - RegistryResponse
 *
 * @author tony-is-coding
 * @date 2022/6/5 15:17
 */
@Data
@ApiModel("用户注册结果")
public class UserRegistryResponse {
    @ApiModelProperty("过期时间")
    private LocalDateTime expireAt;

    @ApiModelProperty("登录成功的token")
    private Long token;
}
