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
}