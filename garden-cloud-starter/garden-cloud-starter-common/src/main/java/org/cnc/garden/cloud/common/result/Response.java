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

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;


/**
 * org.cnc.garden.cloud.common.result - Result
 *
 * @author tony-is-coding
 * @date 2022/6/5 9:59
 */
@Data
@Getter
@ApiModel(value = "统一响应结果")
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "状态码", required = true)
    private int code;

    @ApiModelProperty(value = "消息内容", required = true)
    private String msg;

    @ApiModelProperty(value = "时间戳", required = true)
    private long time;

    @ApiModelProperty(value = "业务数据")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private Response() {
        this.time = System.currentTimeMillis();
    }

    private Response(IResultCode resultCode) {
        this(resultCode, null, resultCode.getMsg());
    }

    private Response(IResultCode resultCode, String msg) {
        this(resultCode, null, msg);
    }

    private Response(IResultCode resultCode, T data) {
        this(resultCode, data, resultCode.getMsg());
    }

    private Response(IResultCode resultCode, T data, String msg) {
        this(resultCode.getCode(), data, msg);
    }

    private Response(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.time = System.currentTimeMillis();
    }

    /**
     * 返回状态码
     *
     * @param resultCode 状态码
     * @param <T>        泛型标识
     * @return ApiResult
     */
    public static <T> Response<T> success(IResultCode resultCode) {
        return new Response<>(resultCode);
    }

    public static <T> Response<T> success(String msg) {
        return new Response<>(ResultCode.SUCCESS, msg);
    }

    public static <T> Response<T> success(IResultCode resultCode, String msg) {
        return new Response<>(resultCode, msg);
    }

    public static <T> Response<T> data(T data) {
        return data(data, DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Response<T> data(T data, String msg) {
        return data(ResultCode.SUCCESS.getCode(), data, msg);
    }

    public static <T> Response<T> data(int code, T data, String msg) {
        return new Response<>(code, data, data == null ? DEFAULT_BLANK_MESSAGE : msg);
    }

    public static <T> Response<T> fail() {
        return new Response<>(ResultCode.FAILURE, ResultCode.FAILURE.getMsg());
    }

    public static <T> Response<T> fail(String msg) {
        return new Response<>(ResultCode.FAILURE, msg);
    }

    public static <T> Response<T> fail(int code, String msg) {
        return new Response<>(code, null, msg);
    }

    public static <T> Response<T> fail(IResultCode resultCode) {
        return new Response<>(resultCode);
    }

    public static <T> Response<T> fail(IResultCode resultCode, String msg) {
        return new Response<>(resultCode, msg);
    }

    public static <T> Response<T> condition(boolean flag) {
        return flag ? success(DEFAULT_SUCCESS_MESSAGE) : fail(DEFAULT_FAILURE_MESSAGE);
    }

    private static final String DEFAULT_SUCCESS_MESSAGE = ResultCode.SUCCESS.getMsg();
    private static final String DEFAULT_FAILURE_MESSAGE = ResultCode.FAILURE.getMsg();
    private static final String DEFAULT_BLANK_MESSAGE = "无数据载体";

}
