package com.boot.redis.service.impl;

import com.boot.redis.dao.UserInfoMapper;
import com.boot.redis.entity.UserInfo;
import com.boot.redis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean save(UserInfo userInfo) {
        int i = userInfoMapper.insert(userInfo);
        return i > 0;
    }

    @Override
    public boolean delete(Long id) {
        int i = userInfoMapper.deleteByPrimaryKey(id);
        return i > 0;
    }

    @Override
    public UserInfo find(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKey(userInfo) > 0;
    }
}
