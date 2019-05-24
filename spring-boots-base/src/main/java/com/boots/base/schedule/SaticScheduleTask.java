package com.boots.base.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 单线程 模式的 定时任务
 */
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {

    @Autowired
    private StringRedisTemplate redisTemplate;

    //3.添加定时任务
    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }


    @Scheduled(cron = "0/5 * * * * ?")
    private void distributedTasks() {
        //1. 获取分布式锁 --> 2.获取成功执行相关操作 --> 3.获取失败执行相关操作
        Long lockTime;
        RedisUtils redisLock = new RedisUtils(redisTemplate, 2000);
        if ((lockTime = redisLock.lock("distributedTasks", "ooAA")) != null) {
          //开始执行任务
          int tryCount = 3;
          while (token == null && --tryCount > 0) {
              token = getTokenInternal(username, password);
          }
          //加入redis缓存
          if (token != null)
              redisService.set(String.format(ACCESS_TOKEN_KEY_TEMPLATE, username), token, tokenTimeout);
          else
              logger.info("{}获取token失败！", username);
          //任务执行完毕 关闭锁
          redisLock.unlock(tokenLockName, lockTime, threadName);
        }


        System.err.println("分布式系统 {执行业务} --- 执行静态定时任务时间: " + LocalDateTime.now());
    }


}