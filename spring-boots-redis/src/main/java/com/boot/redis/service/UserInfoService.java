package com.boot.redis.service;

import com.boot.redis.entity.UserInfo;

public interface UserInfoService {

    boolean save(UserInfo userInfo);

    boolean delete(Long id);

    UserInfo find(Long id);

    boolean update(UserInfo userInfo);

}
