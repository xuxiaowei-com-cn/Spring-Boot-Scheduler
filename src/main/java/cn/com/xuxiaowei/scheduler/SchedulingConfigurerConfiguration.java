package cn.com.xuxiaowei.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

/**
 * 定时器 测试类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Configuration
@EnableScheduling
public class SchedulingConfigurerConfiguration implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        taskRegistrar.addTriggerTask(

                // 定时器执行内容
                () -> log.debug("类:{},方法:{},行号:{},线程:{}", this.getClass(),
                        Thread.currentThread().getStackTrace()[1].getMethodName(),
                        Thread.currentThread().getStackTrace()[1].getLineNumber(),
                        Thread.currentThread().getName()),

                // 每 9 秒执行一次
                triggerContext -> new CronTrigger("0/9 * * * * *").nextExecutionTime(triggerContext)

        );

    }

}
