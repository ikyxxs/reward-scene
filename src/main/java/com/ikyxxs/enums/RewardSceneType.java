package com.ikyxxs.enums;

/**
 * 激励奖励场景枚举
 *
 * @author mubai
 * @date 2020/04/25
 */
public enum RewardSceneType {

    REWARD_VIDEO(1, "激励视频"),
    ;

    private final Integer type;
    private final String desc;

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    RewardSceneType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
