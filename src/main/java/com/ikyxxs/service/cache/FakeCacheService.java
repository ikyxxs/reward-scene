package com.ikyxxs.service.cache;

import com.ikyxxs.domain.PrizeDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 假的缓存服务，只是用来模拟演示的
 *
 * @author mubai
 * @date 2020/04/25
 */
@Service
public class FakeCacheService {

    // 激励奖励缓存
    private static final Map<String, PrizeDto> rewardPrizeCache = new HashMap<>();

    // 请求缓存，用于幂等处理
    private static final Set<String> requestSet = new HashSet<>();

    /**
     * 判断是否是重复请求
     *
     * @param rewardId 激励ID
     * @return 是否重复请求
     */
    public boolean isRequestDuplicate(String rewardId) {
        return requestSet.contains(rewardId);
    }

    /**
     * 缓存请求
     *
     * @param rewardId 激励ID
     */
    public void cacheRequest(String rewardId) {
        requestSet.add(rewardId);
    }

    /**
     * 缓存激励奖励
     *
     * @param rewardId 激励ID
     * @param prize 奖励
     */
    public void cacheRewardPrize(String rewardId, PrizeDto prize) {
        rewardPrizeCache.put(rewardId, prize);
    }

    /**
     * 查询激励奖励
     *
     * @param rewardId 激励ID
     * @return 激励奖励
     */
    public PrizeDto queryRewardPrize(String rewardId) {
        return rewardPrizeCache.get(rewardId);
    }
}
