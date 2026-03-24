package com.mjc813.chapter20.usercurd;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    @PostMapping("/api/insert-data2")
    public void insertData(@RequestBody UserDto userDto) {
        System.out.println("insertData" + userDto.toString());
    }

}
