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
package org.cnc.garden.cloud.web.config;

import io.undertow.Undertow;
import io.undertow.server.DefaultByteBufferPool;
import io.undertow.websockets.jsr.WebSocketDeploymentInfo;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.undertow.UndertowOptions.ENABLE_HTTP2;

/**
 * org.cnc.garden.cloud.web.config - UndertowHttp2AutoConfiguration
 * 定制化的 undertow 对 http2协议支持, 常规下tomcat可以满足需要了
 *
 * @author tony-is-coding
 * @date 2022/6/6 9:35
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(Undertow.class)
@AutoConfigureBefore(ServletWebServerFactoryAutoConfiguration.class)
public class UndertowHttp2AutoConfiguration {
    @Bean
    public WebServerFactoryCustomizer<UndertowServletWebServerFactory> undertowHttp2WebServerFactoryCustomizer() {
        return factory -> factory.addBuilderCustomizers(builder -> builder.setServerOption(ENABLE_HTTP2, true));
    }

    /**
     * 实例化UndertowServerFactoryCustomizer，解决undertow启动提示warn的问题
     *
     * @return UndertowServerFactoryCustomizer
     */
    @Bean
    public WebServerFactoryCustomizer<UndertowServletWebServerFactory> undertowServerFactoryCustomizer() {
        return factory -> factory.addDeploymentInfoCustomizers(deploymentInfo -> {
            WebSocketDeploymentInfo webSocketDeploymentInfo = new WebSocketDeploymentInfo();
            webSocketDeploymentInfo.setBuffers(new DefaultByteBufferPool(false, 1024));
            deploymentInfo.addServletContextAttribute("io.undertow.websockets.jsr.WebSocketDeploymentInfo", webSocketDeploymentInfo);
        });
    }
}
