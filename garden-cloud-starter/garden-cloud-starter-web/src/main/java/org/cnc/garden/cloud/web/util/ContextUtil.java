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
