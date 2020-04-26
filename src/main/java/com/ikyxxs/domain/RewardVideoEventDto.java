package com.ikyxxs.domain;

import java.io.Serializable;

/**
 * 激励视频事件DTO
 *
 * @author mubai
 * @date 2020/04/25
 */
public class RewardVideoEventDto implements Serializable {
    private static final long serialVersionUID = 5803801443302638939L;

    /**
     * 激励ID
     */
    private String rewardId;

    /**
     * 用户ID
     */
    private Long userId;

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
