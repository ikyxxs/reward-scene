package com.ikyxxs.config;

import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Guava EventBus 配置
 *
 * @author mubai
 * @date 2020/04/25
 */
@Configuration
public class EventBusConfig {

    @Bean
    @Scope("singleton")
    public EventBus eventBus() {
        return new EventBus();
    }
}