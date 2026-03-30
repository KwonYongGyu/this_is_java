package com.mjc813.chapter20.gamecrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api") // 클래스 수준에서 /api 선언
public class GameRestController {
    @Autowired
    private GameService gameService;

    @PostMapping("/insert-data")
    public GameDto insertData(@RequestBody GameDto gameDto) {
        System.out.println("insertData" + gameDto.toString());
        this.gameService.insertData(gameDto); // DB에 추가
        return gameDto;
    }

    @PatchMapping("/update-data")
    public GameDto updateData(@RequestBody GameDto gameDto) {
        System.out.println("updateData" + gameDto.toString());
        this.gameService.updateData(gameDto);
        return gameDto;
    }

//    @GetMapping("/get-list") // 브라우저가 /api/get-list 로 요청하면 DB 목록을 JSON으로 던져줍니다.
//    public List<GameDto> getList(SearchDto searchDto) {
//        System.out.println("검색 조건: " + searchDto.toString());
//        return this.gameService.selectList(searchDto); // 서비스에도 메서드 추가
//    }
    @GetMapping("/get-list")
    public Map<String, Object> getList(SearchDto searchDto) {
        Map<String, Object> result = new HashMap<>();
        result.put("list", this.gameService.selectList(searchDto)); // 목록
        result.put("totalCount", this.gameService.selectTotalCount(searchDto)); // 전체 개수
        return result;
    }

    @DeleteMapping("/delete-data")
    public void deleteData(@RequestParam Integer Id) {
        this.gameService.deleteData(Id);
    }
}


