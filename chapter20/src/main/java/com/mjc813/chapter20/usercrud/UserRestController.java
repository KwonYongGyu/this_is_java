package com.mjc813.chapter20.usercrud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    @Autowired
    private UserService userService;

    @PostMapping("/insert-data2")
    public UserDto insertData(@RequestBody UserDto userDto) {
        System.out.println("insertData" + userDto.toString());
        this.userService.insertData(userDto); // DB에 추가
        return userDto;
    }

    @PatchMapping("/update-data2")
    public UserDto updateData(@RequestBody UserDto userDto) {
        System.out.println("updateData" + userDto.toString());
        this.userService.updateData(userDto);
        return userDto;
    }
    // 브라우저가 /api/get-list2로 요청하면 DB 목록을 JSON에 전달
    @GetMapping("/get-list2")
    public List<UserDto> getList() {
        return this.userService.selectAll();
    }

}
