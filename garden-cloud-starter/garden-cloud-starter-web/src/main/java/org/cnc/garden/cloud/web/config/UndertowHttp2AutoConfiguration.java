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
