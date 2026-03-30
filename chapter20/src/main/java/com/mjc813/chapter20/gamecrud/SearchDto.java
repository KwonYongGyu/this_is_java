package com.mjc813.chapter20.gamecrud;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchDto {
    private String searchName;
    private String searchGrade;
    private String searchGenre;

    private int page = 1; // 사용자가 요청한 페이지(기본값1)
    private int recordSize = 5; // 한 페이지당 출력할 데이터 개수

    // MyBatis에서 #{offset}으로 호출할 수 있게 함
    public int getOffset() {
        return (page - 1) * recordSize;
    }
}