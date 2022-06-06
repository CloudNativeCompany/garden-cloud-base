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
package org.cnc.garden.cloud.web.handler;

import lombok.extern.slf4j.Slf4j;
import org.cnc.garden.cloud.common.constant.WebConstant;
import org.cnc.garden.cloud.common.exception.BaseException;
import org.cnc.garden.cloud.common.exception.TokenException;
import org.cnc.garden.cloud.common.result.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.FileNotFoundException;

/**
 * org.cnc.garden.cloud.web.handler - BaseExceptionHandler
 *
 * @author tony-is-coding
 * @date 2022/6/5 10:44
 */
@Slf4j
@RestControllerAdvice
@ResponseBody // responseBody 标识该类所有的返回值都为json类型
public class BaseExceptionHandler {

    /**
     * BaseException 异常捕获处理
     *
     * @param ex 自定义BaseException异常类型
     * @return Result
     */
    @ExceptionHandler(BaseException.class)
    public Response<?> handleBaseException(BaseException ex) {
        log.error("程序异常：" + ex.toString());
        return Response.fail(WebConstant.Status.UNAUTHORIZED.getCode(), ex.getMessage());
    }

    /**
     * TokenException 异常捕获处理
     *
     * @param ex 自定义TokenException异常类型
     * @return Result
     */
    @ExceptionHandler(TokenException.class)
    public Response<?> handleTokenException(TokenException ex) {
        log.error("程序异常==>errorCode:{}, exception:{}", HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
        return Response.fail(WebConstant.Status.UNAUTHORIZED.getCode(), ex.getMessage());
    }

    /**
     * FileNotFoundException,NoHandlerFoundException 异常捕获处理
     *
     * @param exception 自定义FileNotFoundException异常类型
     * @return Result
     */
    @ExceptionHandler({FileNotFoundException.class, NoHandlerFoundException.class})
    public Response<?> noFoundException(Exception exception) {
        log.error("程序异常==>errorCode:{}, exception:{}", HttpStatus.NOT_FOUND.value(), exception.getMessage());
        return Response.fail(WebConstant.Status.NOT_FOUND.getCode(), exception.getMessage());
    }

    /**
     * NullPointerException 空指针异常捕获处理
     *
     * @param ex 自定义NullPointerException异常类型
     * @return Result
     */
    @ExceptionHandler(NullPointerException.class)
    public Response<?> handleNullPointerException(NullPointerException ex) {
        log.error("程序异常：{}" + ex.toString());
        return Response.fail(WebConstant.Status.INTERNAL_SERVER_ERROR.getCode(), ex.getMessage());
    }

    /**
     * 通用Exception异常捕获
     *
     * @param ex 自定义Exception异常类型
     * @return Result
     */
    @ExceptionHandler(Exception.class)
    public Response<?> handleException(Exception ex) {
        log.error("程序异常：" + ex.toString());
        return Response.fail(WebConstant.Status.INTERNAL_SERVER_ERROR.getCode(), ex.getMessage());
    }
}
