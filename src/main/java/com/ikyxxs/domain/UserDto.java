package com.ikyxxs.domain;

import java.io.Serializable;

/**
 * 用户DTO
 *
 * @author mubai
 * @date 2020/04/25
 */
public class UserDto implements Serializable {
    private static final long serialVersionUID = -5747181955404005826L;

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户持有的金币数
     */
    private Integer coin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }
}
