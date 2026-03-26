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

    @DeleteMapping("/delete-data2/{id}")
    public void deleteData(@PathVariable Integer id) {
        System.out.println("삭제할 ID:" + id);
        this.userService.deleteData(id);
    }

    // 브라우저가 /api/get-list2 로 요청하면 DB 목록을 JSON으로 전달
    @GetMapping("/get-list2")
    public List<UserDto> getList() {
        System.out.println("목록 불러오기 요청됨");
        return this.userService.selectAll();
    }

}
