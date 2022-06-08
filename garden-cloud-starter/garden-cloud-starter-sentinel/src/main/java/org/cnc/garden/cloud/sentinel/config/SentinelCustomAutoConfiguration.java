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
import org.springframework.http.HttpStatus;

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

    /**
     * 限流、熔断统一处理类
     */
    @Configuration
    @ConditionalOnClass(HttpServletRequest.class)
    public static class WebmvcHandler {
        @Bean
        public BlockExceptionHandler webmvcBlockExceptionHandler() {
            return (request, response, e) -> {
                response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
                Response<?> result = Response.fail("Too many request, please retry later.");
                response.getWriter().print(JSONObject.toJSONString(result));
            };
        }

    }

}
