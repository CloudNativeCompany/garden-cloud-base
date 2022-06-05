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
package org.cnc.garden.cloud.common.result;

/**
 * org.cnc.garden.cloud.common.result - ResultCode
 *
 * @author tony-is-coding
 * @date 2022/6/5 10:14
 */
public enum ResultCode implements IResultCode{

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 业务异常
     */
    FAILURE(400, "业务异常"),
    /**
     * 服务未找到
     */
    NOT_FOUND(404, "服务未找到"),
    /**
     * 服务异常
     */
    ERROR(500, "服务异常"),
    /**
     * Too Many Requests
     */
    TOO_MANY_REQUESTS(429, "Too Many Requests"),
    /**
     * 服务不可用
     */
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    /**
     * 参数错误
     */
    GLOBAL_PARAM_ERROR(4000, "参数错误"),
    /**
     * 获取当前用户失败
     */
    CURRENT_USER_FAIL(10001, "获取当前用户失败"),
    /**
     * 用户是超级管理员，不可以修改状态
     */
    UPDATE_USER_STATUS(10002, "用户是超级管理员，不可以修改状态"),
    /**
     * 用户是超级管理员，不可以修改密码
     */
    UPDATE_USER_PASSWORD(10003, "用户是超级管理员，不可以修改密码"),
    /**
     * 用户未登录，请登陆后进行访问
     */
    USER_NEED_LOGIN(11001, "用户未登录，请登陆后进行访问"),
    /**
     * 该用户已在其它地方登录
     */
    USER_MAX_LOGIN(11002, "该用户已在其它地方登录"),
    /**
     * 长时间未操作，自动退出
     */
    USER_LOGIN_TIMEOUT(11003, "长时间未操作，自动退出"),
    /**
     * 用户被禁11005用
     */
    USER_DISABLED(11004, "用户被禁11005用"),
    /**
     * 用户被锁定
     */
    USER_LOCKED(11005, "用户被锁定"),
    /**
     * 用户名或密码错误
     */
    USER_PASSWORD_ERROR(11006, "用户名或密码错误"),
    /**
     * 用户密码过期
     */
    USER_PASSWORD_EXPIRED(11007, "用户密码过期"),
    /**
     * 用户账号过期
     */
    USER_ACCOUNT_EXPIRED(11008, "用户账号过期"),
    /**
     * 没有该用户
     */
    USER_NOT_EXIST(11009, "没有该用户"),
    /**
     * 用户登录失败
     */
    USER_LOGIN_FAIL(11010, "用户登录失败"),
    /**
     * 验证码错误
     */
    VERIFY_CODE_ERROR(11011, "验证码错误"),
    /**
     * 用户已存在
     */
    USER_IS_EXIST(11012, "用户已存在"),
    /**
     * 无权访问
     */
    NO_AUTHENTICATION(1003006, "无权访问"),
    /**
     * 角色ID无效
     */
    ROLE_IS_NOT_EXIST(13001, "角色ID无效"),
    /**
     * 角色代码已存在
     */
    ROLE_IS_EXIST(13002, "角色代码已存在")

    ;
    /**
     * 状态码
     */
    final int code;
    /**
     * 消息内容
     */
    final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
