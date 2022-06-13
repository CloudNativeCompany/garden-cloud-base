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

import lombok.extern.slf4j.Slf4j;
import org.cnc.garden.cloud.common.context.UserInfoContext;
import org.cnc.garden.cloud.common.entity.UserInfo;
import org.cnc.garden.cloud.web.annotation.User;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * org.cnc.garden.cloud.web.config - WebMVCAutoConfiguration
 *
 * @author tony-is-coding
 * @date 2022/6/5 20:44
 */
@Slf4j
@AutoConfiguration
public class WebMvcAutoConfiguration implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        // 将用户信息数据反转注入到 被 @User 标注的注解下
        final HandlerMethodArgumentResolver userInfoResolver = new HandlerMethodArgumentResolver() {
            @Override
            public boolean supportsParameter(MethodParameter param) {
                return param.hasParameterAnnotation(User.class) && param.getParameterType().isAssignableFrom(UserInfo.class);
            }

            @Override
            public Object resolveArgument(MethodParameter param, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
                // 从上下文中获取用户信息
                log.info("User参数反转注入");
                return UserInfoContext.get();
            }
        };
        resolvers.add(userInfoResolver);

        WebMvcConfigurer.super.addArgumentResolvers(resolvers);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加用户信息相关拦截, 尝试获取用户信息, 如果没有获取到足够的用户信息数据, 则进行异常抛出
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                log.info("用户拦截前置, 请求刚刚到达...");
                UserInfoContext.set(getUserInfo(request));
                return HandlerInterceptor.super.preHandle(request, response, handler);
            }
            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                log.info("用户拦截后置, 业务已经完成...");
                UserInfoContext.clear();
                HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
            }
            private UserInfo getUserInfo(HttpServletRequest request) {
                return UserInfo.anonymous();
            }
        });

        // todo: other interceptors
    }
}
