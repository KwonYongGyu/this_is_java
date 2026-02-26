package com.mjc813.practice;

public interface CRUD<TYPE>{
    void add(TYPE item); // item을 마지막 순서에 추가한다.
    int size(); // 전체 item의 개수를 리턴한다.

    NintendoGame set(int index, NintendoGame item);

    NintendoGame remove(int index);

    com.mjc813.practice.NintendoGame set(int index); // index 번째의 item을 삭제한다. 리턴은 item값이다.
    TYPE get(int index); // index 번째의 item을 리턴한다.
    String getJson(int index); // index 번째의 item을 JSON 문자열로 리턴한다. 옵션
    String getJsonAllItems(); // 모든 item들을 JSON 문자열로 리턴한다. 옵션
}
