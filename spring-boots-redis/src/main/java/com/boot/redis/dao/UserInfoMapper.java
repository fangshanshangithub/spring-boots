package com.boot.redis.dao;

import com.boot.redis.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}