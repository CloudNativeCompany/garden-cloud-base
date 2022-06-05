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
