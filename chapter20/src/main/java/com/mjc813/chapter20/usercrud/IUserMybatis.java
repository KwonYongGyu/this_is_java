package com.mjc813.chapter20.usercrud;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserMybatis {
    void insertData(UserDto newUser);
    void updateData(UserDto userData);

    // 전체 목록을 가져오는 메소드 추가
    List<UserDto> selectAll();
}
