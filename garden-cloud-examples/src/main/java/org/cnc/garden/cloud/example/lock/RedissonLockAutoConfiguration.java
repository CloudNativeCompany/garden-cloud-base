package org.cnc.garden.cloud.example.lock;

import org.redisson.api.RedissonClient;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * org.cnc.garden.cloud.example.lock - RedissonAutoConfiguration
 *
 * @author tony-is-coding
 * @date 2022/6/12 10:05
 */
@Configuration
@AutoConfigureAfter(RedissonAutoConfiguration.class)
public class RedissonLockAutoConfiguration {

    @Bean
    public RedissonLock redissonLock(RedissonClient redissonClient) {
        return new RedissonLock(redissonClient);
    }

    @ConditionalOnBean(RedissonLock.class)
    @Bean
    public RedissonLockAspect redissonLockAspect(RedissonLock redissonLock) {
        return new RedissonLockAspect(redissonLock);
    }

}
