package com.ikyxxs.eventbus;

import com.google.common.eventbus.Subscribe;
import com.ikyxxs.domain.PrizeDto;
import com.ikyxxs.domain.RewardVideoEventDto;
import com.ikyxxs.domain.UserDto;
import com.ikyxxs.service.cache.FakeCacheService;
import com.ikyxxs.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 激励事件消息监听
 *
 * @author mubai
 * @date 2020/04/25
 */
@Component
public class RewardEventListener {

    @Autowired
    private UserService userService;

    @Autowired
    private FakeCacheService fakeCacheService;

    @Subscribe
    public void onRewardVideoEvent(RewardVideoEventDto event) {
        if (null == event.getUserId() || null == event.getRewardId()) {
            return;
        }

        // 查询用户
        UserDto user = userService.queryUser(event.getUserId());
        // 查询激励视频播放后的奖励
        PrizeDto prize = fakeCacheService.queryRewardPrize(event.getRewardId());

        // 发放奖励的金币
        user.setCoin(user.getCoin() + prize.getCoin());
        userService.updateUser(user);
    }
}
