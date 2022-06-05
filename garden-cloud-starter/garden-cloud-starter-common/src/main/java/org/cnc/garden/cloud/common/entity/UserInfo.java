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
package org.cnc.garden.cloud.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * org.cnc.garden.cloud.common.entity - UserInfo
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
    private String userId;
    /**
     * 账号
     */
    private String account;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 企业ID
     */
    private String companyId;
    /**
     * 部门id
     */
    private String deptId;
    /**
     * 岗位id
     */
    private String jobId;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 登录类型
     */
    private int type;


    public static UserInfo anonymous(){
        UserInfo info = new UserInfo();
        info.setAccount("tony-is-coding");
        info.setCompanyId("sajk1lk12u378kasj84anvu24554");
        info.setDeptId("sajk1lk12u378kasj84anvu2455jj");
        info.setUserId("23189300892");
        info.setJobId("001");
        return info;
    }

}
