package com.mjc813.chapter20.usercrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserMybatis userMybatis;

    public void insertData(UserDto newUser) {
        this.userMybatis.insertData(newUser);
    }

    public void updateData(UserDto userData) {
        this.userMybatis.updateData(userData);
    }

    public List<UserDto> selectAll() {
        return this.userMybatis.selectAll();
    }
}
