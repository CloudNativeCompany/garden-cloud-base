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
package org.cnc.garden.cloud.common.exception;

import org.cnc.garden.cloud.common.result.ResultCode;
import org.springframework.http.HttpStatus;

/**
 * org.cnc.garden.cloud.common.exception - BaseException
 *
 * @author tony-is-coding
 * @date 2022/6/5 10:47
 */
public class BaseException  extends RuntimeException{

    private static final long serialVersionUID = 5782968730281544562L;

    private int status = ResultCode.ERROR.getCode();

    public BaseException(String message) {
        super(message);
    }

    public BaseException(HttpStatus status, String message) {
        super(message);
        this.status = status.value();
    }
}
