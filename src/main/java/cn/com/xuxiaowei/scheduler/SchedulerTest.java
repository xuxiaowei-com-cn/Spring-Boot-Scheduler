package cn.com.xuxiaowei.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时器 测试类
 * <p>
 * 多线程
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Component
@EnableAsync
@EnableScheduling
public class SchedulerTest {

    /**
     * 每 5 秒执行一次
     *
     * @see Scheduled#cron()
     */
    @Async
    @Scheduled(cron = "0/5 * * * * *")
    public void job1() {
        log.debug("类:{},方法:{},行号:{},线程:{}", this.getClass(),
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                Thread.currentThread().getStackTrace()[1].getLineNumber(),
                Thread.currentThread().getName());
    }

    /**
     * 每 6 秒执行一次
     *
     * @see Scheduled#fixedDelay() 单位：毫秒
     */
    @Async
    @Scheduled(fixedDelay = 6000)
    public void job2() {
        log.debug("类:{},方法:{},行号:{},线程:{}", this.getClass(),
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                Thread.currentThread().getStackTrace()[1].getLineNumber(),
                Thread.currentThread().getName());
    }

    /**
     * 启动 8 秒后开始执行，每 7 秒执行一次
     *
     * @see Scheduled#fixedDelay() 单位：毫秒
     * @see Scheduled#initialDelay() 第一次执行 {@link Scheduled#fixedRate()} 或 {@link Scheduled#fixedDelay()} 任务之前要延迟的毫秒数。
     */
    @Async
    @Scheduled(fixedDelay = 7000, initialDelay = 8000)
    public void job3() {
        log.debug("类:{},方法:{},行号:{},线程:{}", this.getClass(),
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                Thread.currentThread().getStackTrace()[1].getLineNumber(),
                Thread.currentThread().getName());
    }

}
