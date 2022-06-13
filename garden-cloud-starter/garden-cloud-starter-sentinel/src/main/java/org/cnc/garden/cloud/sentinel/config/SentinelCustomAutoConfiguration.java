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
package org.cnc.garden.cloud.sentinel.config;

import com.alibaba.cloud.sentinel.feign.SentinelFeignAutoConfiguration;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.fastjson.JSONObject;
import org.cnc.garden.cloud.common.factory.YamlPropertySourceFactory;
import org.cnc.garden.cloud.common.result.Response;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.servlet.http.HttpServletRequest;

/**
 * org.cnc.garden.cloud.sentinel.config - SentinelAutoConfiguration
 *
 * @author tony-is-coding
 * @date 2022/6/6 16:50
 */
@Configuration(proxyBeanMethods= false)
@PropertySource(factory = YamlPropertySourceFactory.class, value ="classpath:sentinel-conf.yml")
@AutoConfigureBefore(SentinelFeignAutoConfiguration.class)
public class SentinelCustomAutoConfiguration {

    public static final int HTTP_STATUS_TOO_MANY_REQUEST = 429;

    /**
     * 限流、熔断统一处理类
     */
    @Configuration
    @ConditionalOnClass(HttpServletRequest.class)
    public static class WebmvcHandler {
        @Bean
        public BlockExceptionHandler webmvcBlockExceptionHandler() {
            return (request, response, e) -> {
                response.setStatus(HTTP_STATUS_TOO_MANY_REQUEST);
                Response<?> result = Response.fail("Too many request, please retry later.");
                response.getWriter().print(JSONObject.toJSONString(result));
            };
        }

    }

}
