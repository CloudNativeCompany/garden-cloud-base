package org.cnc.garden.cloud.common;

/**
 * org.cnc.garden.cloud.common - IResultCode
 *
 * 接口状态码返回
 *
 * @author tony-is-coding
 * @date 2022/6/5 9:58
 */
public interface IResultCode {
    /**
     * 返回码
     *
     * @return int
     */
    int getCode();

    /**
     * 返回消息
     *
     * @return String
     */
    String getMsg();
}
