package com.ikyxxs.service.reward;

import com.ikyxxs.domain.PrizeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 激励工厂类，根据激励场景类型调用对应的处理器处理
 *
 * @author mubai
 * @date 2020/04/25
 */
@Service
public class RewardFactory {

    private final Map<Integer, RewardProcessor> rewardProcessorMap;

    @Autowired
    public RewardFactory(List<RewardProcessor> rewardVideoProcessorList) {
        this.rewardProcessorMap = rewardVideoProcessorList.stream()
                .collect(Collectors.toMap(RewardProcessor::getRewardSceneType
                        , a -> a, (oldVal, newVal) -> newVal));
    }

    /**
     * 激励视频准备阶段（在触发激励场景时主动调用）：
     * 1、生成唯一奖励ID(rewardId)
     * 2、缓存激励奖励，用于后续回调发放奖励
     *
     * @param rewardSceneType 激励奖励场景
     * @param userId 用户id
     * @param prize 奖励
     * @return 激励奖励id
     */
    public String rewardPrepare(Integer rewardSceneType, Long userId, PrizeDto prize) {
        return rewardProcessorMap.get(rewardSceneType).rewardPrepare(rewardSceneType, userId, prize);
    }

    /**
     * 激励奖励上报接口（激励视频播放完调用）
     *
     * @param rewardSceneType 奖励场景
     * @param userId 用户id
     * @param rewardId 奖励id
     */
    public void obtainRewardPrize(Integer rewardSceneType, Long userId, String rewardId) {
        rewardProcessorMap.get(rewardSceneType).obtainRewardPrize(rewardSceneType, userId, rewardId);
    }
}
