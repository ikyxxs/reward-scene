package com.ikyxxs;

import com.ikyxxs.domain.PrizeDto;
import com.ikyxxs.domain.RewardReq;
import com.ikyxxs.domain.UserDto;
import com.ikyxxs.service.activity.ActivityService;
import com.ikyxxs.service.reward.RewardService;
import com.ikyxxs.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RewardTest {

    @Autowired
    private UserService userService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private RewardService rewardService;

    @Test
    public void testReward() {
        // 初始化用户
        UserDto user = userService.initUser();
        System.out.println("用户 " + user.getId() + " 持有金币 " + user.getCoin());

        // 用户参与活动获得奖励
        PrizeDto prize = activityService.play(user.getId());
        System.out.println("用户参与活动获得金币 10");

        // 查询用户信息
        user = userService.queryUser(user.getId());
        System.out.println("用户 " + user.getId() + " 持有金币 " + user.getCoin());

        // 用户看激励视频获得翻倍的奖励
        RewardReq req = new RewardReq();
        req.setRewardId(prize.getRewardId());
        req.setUserId(user.getId());

        // 请求激励视频
        System.out.println("用户选择看激励视频获得额外的翻倍奖励");
        rewardService.obtainAdvert(req);

        // 激励视频看完回调
        System.out.println("用户看完激励视频后获得额外的翻倍奖励");
        rewardService.rewardedPrize(req);

        // 查询用户信息
        user = userService.queryUser(user.getId());
        System.out.println("用户 " + user.getId() + " 持有金币 " + user.getCoin());
    }
}
