package com.mjc813.chapter20.gamecrud;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IGameMybatis {
    void insertData(GameDto newGame);
    void updateData(GameDto gameData);
    void deleteData(Integer Id);
    int selectTotalCount(SearchDto searchDto);
    // 전체 목록을 가져오는 메서드 추가
    List<GameDto> selectList(SearchDto searchDto);
}
