package org.cnc.garden.cloud.example.lock;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * org.cnc.garden.cloud.example.lock - RedissonLock
 *
 * @author tony-is-coding
 * @date 2022/6/12 10:52
 */
@Slf4j
public class RedissonLock {

    private final RedissonClient redissonClient;

    public RedissonLock(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    /**
     * 加锁操作
     *
     * @return boolean
     */
    public boolean lock(String lockName, long expireSeconds) {
        RLock rLock = redissonClient.getLock(lockName);
        boolean getLock;
        try {
            getLock = rLock.tryLock(0, expireSeconds, TimeUnit.SECONDS);
            if (getLock) {
                log.info("获取Redisson分布式锁[成功],lockName={}", lockName);
            } else {
                log.info("获取Redisson分布式锁[失败],lockName={}", lockName);
            }
        } catch (InterruptedException e) {
            log.error("获取Redisson分布式锁[异常]，lockName=" + lockName, e);
            e.printStackTrace();
            return false;
        }
        return getLock;
    }

    /**
     * 解锁
     *
     * @param lockName 锁名称
     */
    public void release(String lockName) {
        redissonClient.getLock(lockName).unlock();
    }
}
