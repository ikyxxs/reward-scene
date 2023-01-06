package com.ikyxxs.domain;

import java.io.Serializable;

/**
 * 激励请求参数
 *
 * @author mubai
 * @date 2020/04/25
 */
public class RewardReq implements Serializable {
    private static final long serialVersionUID = -1217003659841731170L;

    /**
     * 激励奖励场景类型
     * @see com.ikyxxs.enums.RewardSceneType
     */
    private Integer rewardSceneType;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 激励ID
     */
    private String rewardId;

    public Integer getRewardSceneType() {
        return rewardSceneType;
    }

    public void setRewardSceneType(Integer rewardSceneType) {
        this.rewardSceneType = rewardSceneType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }
}
