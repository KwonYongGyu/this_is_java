package com.mjc813.chapter20.gamecrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private IGameMybatis gameMybatis;

    public void insertData(GameDto gameDto) {
        this.gameMybatis.insertData(gameDto);
    }
    public void updateData(GameDto gameData) {
        this.gameMybatis.updateData(gameData);
    }

    public List<GameDto> selectList(SearchDto searchDto) {
        // 컨트롤러에서 넘어온 검색 조건(SearchDto)을 MyBatis로 전달합니다.
        return this.gameMybatis.selectList(searchDto);
    }
    public void deleteData(Integer Id) {
        this.gameMybatis.deleteData(Id);
    }
}
