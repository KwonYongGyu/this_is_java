package com.mjc813.checkTest;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    public List<Board> getBoardlist() {
    List<Board> list = new ArrayList<>();

    list.add(new Board("제목2", "내용2"));
    list.add(new Board("제목3", "내용3"));

    return list;
    }

}
