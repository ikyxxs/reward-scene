package com.ikyxxs.domain;

import java.io.Serializable;

/**
 * 奖励DTO
 *
 * @author mubai
 * @date 2020/04/25
 */
public class PrizeDto implements Serializable {
    private static final long serialVersionUID = 9051164556292274553L;

    /**
     * 奖励的金币
     */
    private Integer coin;

    /**
     * 激励ID
     */
    private String rewardId;

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }
}
