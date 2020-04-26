package com.ikyxxs.service.reward;

import com.google.common.base.Joiner;
import com.ikyxxs.domain.RewardVideoEventDto;
import com.ikyxxs.domain.PrizeDto;
import com.ikyxxs.enums.RewardSceneType;
import com.ikyxxs.eventbus.RewardEventHandler;
import com.ikyxxs.service.cache.FakeCacheService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 激励视频场景处理
 *
 * @author mubai
 * @date 2020/04/25
 */
@Service
public class RewardVideoProcessor implements RewardProcessor {

    @Autowired
    private RewardEventHandler rewardEventHandler;

    @Autowired
    private FakeCacheService fakeCacheService;

    @Override
    public Integer getRewardSceneType() {
        return RewardSceneType.REWARD_VIDEO.getType();
    }

    @Override
    public String rewardPrepare(Integer rewardSceneType, Long userId, PrizeDto prize) {
        // 偷懒直接用随机数了
        String rewardId = Joiner.on("-").join(rewardSceneType, RandomStringUtils.randomAlphanumeric(6));
        fakeCacheService.cacheRewardPrize(rewardId, prize);
        return rewardId;
    }

    @Override
    public void obtainRewardPrize(Integer rewardSceneType, Long userId, String rewardId) {
        // 通过事件通知处理激励奖励发放
        RewardVideoEventDto event = new RewardVideoEventDto();
        event.setUserId(userId);
        event.setRewardId(rewardId);
        rewardEventHandler.eventPost(event);
    }
}
