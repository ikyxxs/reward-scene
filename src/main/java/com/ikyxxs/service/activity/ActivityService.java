package com.ikyxxs.service.activity;

import com.ikyxxs.domain.PrizeDto;
import com.ikyxxs.domain.RewardReq;
import com.ikyxxs.domain.UserDto;
import com.ikyxxs.enums.RewardSceneType;
import com.ikyxxs.service.reward.RewardService;
import com.ikyxxs.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 活动服务，粗略表示用户的能获得金币奖励的行为
 *
 * @author mubai
 * @date 2020/04/25
 */
@Service
public class ActivityService {

    @Autowired
    private UserService userService;

    @Autowired
    private RewardService rewardService;

    /**
     * 参与活动并获取的金币奖励
     *
     * @param userId 用户id
     * @return 金币奖励
     */
    public PrizeDto play(Long userId) {
        PrizeDto prize = new PrizeDto();
        prize.setCoin(10);

        // 获取激励ID
        RewardReq req = new RewardReq();
        req.setUserId(userId);
        req.setRewardSceneType(RewardSceneType.REWARD_VIDEO.getType());
        prize.setRewardId(rewardService.prepareAdvert(req, prize));

        // 发放参与活动后的金币奖励
        UserDto user = userService.queryUser(userId);
        user.setCoin(user.getCoin() + prize.getCoin());
        userService.updateUser(user);

        return prize;
    }
}
