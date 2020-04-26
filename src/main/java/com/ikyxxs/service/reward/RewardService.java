package com.ikyxxs.service.reward;

import com.ikyxxs.domain.PrizeDto;
import com.ikyxxs.domain.RewardAdDto;
import com.ikyxxs.domain.RewardReq;
import com.ikyxxs.domain.UserDto;
import com.ikyxxs.service.cache.FakeCacheService;
import com.ikyxxs.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 激励服务
 *
 * @author mubai
 * @date 2020/04/25
 */
@Service
public class RewardService {

    @Autowired
    private RewardFactory rewardFactory;

    @Autowired
    private FakeCacheService fakeCacheService;

    @Autowired
    private UserService userService;

    /**
     * 生成唯一的激励ID
     *
     * @param req 激励请求参数
     * @param prize 激励奖励
     * @return 激励ID
     */
    public String prepareAdvert(RewardReq req, PrizeDto prize) {
        return rewardFactory.rewardPrepare(req.getRewardSceneType(), req.getUserId(), prize);
    }

    /**
     * 请求激励视频广告，略
     *
     * @param req 请求参数
     * @return 激励视频广告
     */
    public RewardAdDto obtainAdvert(RewardReq req) {
        return new RewardAdDto();
    }

    /**
     * 完成激励行为后的回调（比如播放完激励视频）
     *
     * @param req 激励请求参数
     */
    public void rewardedPrize(RewardReq req) {
        if (StringUtils.isBlank(req.getRewardId())) {
            return;
        }

        // 幂等性
        if (fakeCacheService.isRequestDuplicate(req.getRewardId())) {
            return;
        }
        fakeCacheService.cacheRequest(req.getRewardId());

        // 查询用户信息
        UserDto baseUser = userService.queryUser(req.getUserId());

        // 奖励发放
        Integer rewardSceneType = Integer.parseInt(req.getRewardId().split("-")[0]);
        rewardFactory.obtainRewardPrize(rewardSceneType, baseUser.getId(), req.getRewardId());
    }
}
