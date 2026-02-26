package com.mjc813.practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NintendoGame {
    private String name;
    private Grade grade;
    private Integer price;
}
