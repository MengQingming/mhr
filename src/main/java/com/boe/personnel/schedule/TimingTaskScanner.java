package com.boe.personnel.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.support.TaskUtils;
import org.springside.modules.utils.Threads;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class TimingTaskScanner implements Runnable {

	private static Logger logger = LoggerFactory.getLogger(TimingTaskScanner.class);


	private int initialDelay = 0;
	private int period = 0;
	private int shutdownTimeout = Integer.MAX_VALUE;
	private ScheduledExecutorService scheduledExecutorService;

	@PostConstruct
	public void start() throws Exception {
		Validate.isTrue(period > 0);
		Runnable task = TaskUtils.decorateTaskWithErrorHandler(this, null, true);

		// 创建单线程的SechdulerExecutor,并用guava的ThreadFactoryBuilder设定生成线程的名称
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryBuilder().setNameFormat("JdkTimerJob-%1$d").build());
		scheduledExecutorService.scheduleWithFixedDelay(task, initialDelay, period, TimeUnit.SECONDS);
	}

	@PreDestroy
	public void stop() {
		Threads.normalShutdown(scheduledExecutorService, shutdownTimeout, TimeUnit.SECONDS);
	}

	/**
	 * 定时打印当前用户数到日志.
	 */
	@Override
	public void run() {
		
	}

	/**
	 * 设置任务初始启动延时时间.
	 */
	public void setInitialDelay(int initialDelay) {
		this.initialDelay = initialDelay;
	}

	/**
	 * 设置任务间隔时间,单位秒.
	 */
	public void setPeriod(int period) {
		this.period = period;
	}

	/**
	 * 设置normalShutdown的等待时间, 单位秒.
	 */
	public void setShutdownTimeout(int shutdownTimeout) {
		this.shutdownTimeout = shutdownTimeout;
	}
}
