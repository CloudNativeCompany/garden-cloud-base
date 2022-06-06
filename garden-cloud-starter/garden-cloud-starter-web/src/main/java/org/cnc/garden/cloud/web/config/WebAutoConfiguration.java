package org.cnc.garden.cloud.web.config;

import org.cnc.garden.cloud.web.util.ContextUtil;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * org.cnc.garden.cloud.web.config - WebAutoConfiguration
 *
 * @author tony-is-coding
 * @date 2022/6/6 11:21
 */
@AutoConfiguration
public class WebAutoConfiguration {
    @Bean
    public ContextUtil contextUtil() {
        return new ContextUtil();
    }
}
