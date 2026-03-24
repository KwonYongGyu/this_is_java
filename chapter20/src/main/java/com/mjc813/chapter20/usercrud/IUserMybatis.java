package com.mjc813.chapter20.usercrud;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMybatis {
    void insertData(UserDto newUser);
}
