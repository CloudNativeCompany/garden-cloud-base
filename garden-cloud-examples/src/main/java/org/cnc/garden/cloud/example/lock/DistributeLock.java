package org.cnc.garden.cloud.example.lock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * org.cnc.garden.cloud.example.lock - DistributeLock
 *
 * @author tony-is-coding
 * @date 2022/6/12 10:28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DistributeLock {
    /**
     * 等待获取锁的时长, 允许在知道超时时间范围内不断尝试获取锁
     * <br/>
     * 单位: 毫秒
     */
    long waitMs() default 500;

    /**
     * 持有锁时长, 持有锁时长超过这个数自动释放锁
     * <br/>
     * 单位: 秒
     */
    long expireSecond();

    /**
     * 锁名称
     */
    String name();
}
