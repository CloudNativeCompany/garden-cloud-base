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
        log.info("[开始]执行RedisLock环绕通知,获取Redis分布式锁开始");
        //获取锁名称
        String lockName = distributedLock.name();
        //获取超时时间并获取锁
        if (!redissonLock.lock(lockName, distributedLock.expireMs())) {
            log.error("获取Redis分布式锁[失败]");
            throw new RuntimeException(MessageFormat.format("获取Redis分布式失败:{0}", lockName));
        }
        log.info("获取Redis分布式锁[成功]，加锁完成，开始执行业务逻辑...");
        try {
            return joinPoint.proceed();
        } finally {
            redissonLock.release(lockName);
            log.info("释放Redis分布式锁[成功]，解锁完成，结束业务逻辑...");
            log.info("[结束]执行RedisLock环绕通知");
        }
    }
}
