package com.ming.stock.pojo.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "task.pool")
public class TaskThreadPoolInfo {
    /**
     * 核心线程数(获取硬件)：线程池创建的时候初始化线程数
     */
    private Integer corePoolSize;
    private Integer maxPoolSize;
    private Integer keepAliveSeconds;
    private Integer queueCapacity;
}
