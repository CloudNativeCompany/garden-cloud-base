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
    // redisson distribute lock
    long expireMs(); // expire million second

    String name(); // lock name
}
