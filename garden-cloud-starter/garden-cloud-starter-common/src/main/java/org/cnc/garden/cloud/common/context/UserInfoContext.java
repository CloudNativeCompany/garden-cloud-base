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
