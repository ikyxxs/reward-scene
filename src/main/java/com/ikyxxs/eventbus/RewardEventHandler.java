package com.ikyxxs.eventbus;

import com.google.common.eventbus.EventBus;
import com.ikyxxs.domain.RewardVideoEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 激励事件消息处理
 *
 * @author mubai
 * @date 2020/04/25
 */
@Component
public class RewardEventHandler {

    @Autowired
    private EventBus eventBus;

    @Autowired
    private RewardEventListener eventListener;

    @PostConstruct
    public void init() {
        eventBus.register(eventListener);
    }

    @PreDestroy
    public void destroy() {
        eventBus.unregister(eventListener);
    }

    /**
     * 激励事件发布
     */
    public void eventPost(RewardVideoEventDto event) {
        eventBus.post(event);
    }
}
