package org.cnc.garden.cloud.example.lock;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.text.MessageFormat;

/**
 * org.cnc.garden.cloud.example.lock - RedissonLockAspect
 *
 * @author tony-is-coding
 * @date 2022/6/12 10:26
 */
@Slf4j
@Aspect
public class RedissonLockAspect {
    private final RedissonLock redissonLock;

    public RedissonLockAspect(RedissonLock redissonLock) {
        this.redissonLock = redissonLock;
    }
    @Around("@annotation(distributedLock)")
    public Object around(ProceedingJoinPoint joinPoint, DistributeLock distributedLock) throws Throwable {
        String lockName = distributedLock.name();
        if (!redissonLock.lock(lockName, distributedLock.waitMs(), distributedLock.expireSecond())) {
            log.error("获取分布式锁失败: " + lockName);
            throw new RuntimeException(MessageFormat.format("获取Redis分布式失败:{0}", lockName));
        }
        try {
            return joinPoint.proceed();
        } finally {
            redissonLock.release(lockName);
        }
    }
}
