package com.ikyxxs.service.user;

import com.ikyxxs.domain.UserDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户服务，只是用来模拟演示的
 *
 * @author mubai
 * @date 2020/04/25
 */
@Service
public class UserService {

    private static final Map<Long, UserDto> userRepository = new HashMap<>();

    /**
     * 初始化用户
     *
     * @return 用户信息
     */
    public UserDto initUser() {
        UserDto user = new UserDto();
        user.setId(1L);
        user.setCoin(0);
        userRepository.put(user.getId(), user);
        return user;
    }

    /**
     * 查询用户
     *
     * @param userId 用户id
     * @return 用户信息
     */
    public UserDto queryUser(Long userId) {
        return userRepository.get(userId);
    }

    /**
     * 更新用户
     *
     * @param user 用户信息
     */
    public void updateUser(UserDto user) {
        userRepository.put(user.getId(), user);
    }
}
