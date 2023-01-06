package com.ikyxxs.service.reward;

import com.ikyxxs.domain.PrizeDto;

/**
 * 激励处理接口
 *
 * @author mubai
 * @date 2020/04/25
 */
public interface RewardProcessor {

    /**
     * 获取激励奖励场景
     *
     * @return 激励奖励场景
     */
    Integer getRewardSceneType();

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
    String rewardPrepare(Integer rewardSceneType, Long userId, PrizeDto prize);

    /**
     * 奖励发放
     *
     * @param rewardSceneType 激励奖励场景
     * @param userId 用户id
     * @param rewardId 激励奖励id
     */
    void obtainRewardPrize(Integer rewardSceneType, Long userId, String rewardId);
}
