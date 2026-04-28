package com.mjc813.swim_db.models.swimpool;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SwimPoolDto {
    private Long id;
    private String name;
    private String tel;
    private String addr1;
    private String addr2;
    private String lanes;
    private String size;

}
