/*
 *     Copyright 2022 tony-is-coding  belong to `org.garden`
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
package org.cnc.garden.cloud.web.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * org.cnc.garden.cloud.web.entity - UserInfo
 *
 * @author tony-is-coding
 * @date 2022/6/5 10:33
 */
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1599282604110237521L;
    /**
     * 用户id
     */
    @ApiModelProperty(hidden = true)
    private String userId;
    /**
     * 账号
     */
    @ApiModelProperty(hidden = true)
    private String account;
    /**
     * 用户名
     */
    @ApiModelProperty(hidden = true)
    private String userName;
    /**
     * 企业ID
     */
    @ApiModelProperty(hidden = true)
    private String companyId;
    /**
     * 部门id
     */
    @ApiModelProperty(hidden = true)
    private String deptId;
    /**
     * 岗位id
     */
    @ApiModelProperty(hidden = true)
    private String postId;
    /**
     * 角色id
     */
    @ApiModelProperty(hidden = true)
    private String roleId;
    /**
     * 角色名
     */
    @ApiModelProperty(hidden = true)
    private String roleName;

    /**
     * 登录类型
     */
    @ApiModelProperty(hidden = true)
    private int type;

}
