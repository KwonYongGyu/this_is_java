package com.mjc813.chapter20.usercrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserMybatis userMybatis;

    public void insertData(UserDto newUser) {
        this.userMybatis.insertData(newUser);
    }
}
