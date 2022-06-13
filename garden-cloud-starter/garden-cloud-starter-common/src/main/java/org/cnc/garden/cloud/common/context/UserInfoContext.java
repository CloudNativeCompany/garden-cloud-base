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
package org.cnc.garden.cloud.common.context;

import org.cnc.garden.cloud.common.entity.UserInfo;

/**
 * org.cnc.garden.cloud.common.context - UserInfoContext
 *
 * @author tony-is-coding
 * @date 2022/6/5 18:01
 */
public class UserInfoContext {

    // TODO: 考虑全局上下文  user-info 信息需要清除问题;
    //  thread-local 在线程池使用情况下不会默认清除, 所以需要进行 clear
    //  考虑 1. 在servlet-filter 后置进行清理
    //      2. 全局发号器请求版本号机制？
    private static final ThreadLocal<UserInfo> USER_INFO_HOLDER = new ThreadLocal<>();

    public static UserInfo get() {
        return USER_INFO_HOLDER.get();
    }

    public static void set(UserInfo info) {
        USER_INFO_HOLDER.set(info);
    }

    public static void clear(){
        USER_INFO_HOLDER.remove();
    }

}
