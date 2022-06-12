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
package org.cnc.garden.cloud.web.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * org.cnc.garden.cloud.common.util - ContextUtil
 *
 * @author tony-is-coding
 * @date 2022/6/6 10:08
 */
@Slf4j
public class ContextUtil implements ApplicationContextAware, DisposableBean {

    public static  ApplicationContext ctx = null;

    public static <T> T getBean(Class<T> clz) {
        assertContextInjected();
        return ctx.getBean(clz);
    }


    private static void assertContextInjected() {
        if (ctx == null) {
            throw new UnsupportedOperationException("未检查到容器注入, 需要现启动Spring 容器上下文");
        }
    }

    @Override
    public void destroy() throws Exception {
        ctx = null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ctx != null) {

        }

    }
}
