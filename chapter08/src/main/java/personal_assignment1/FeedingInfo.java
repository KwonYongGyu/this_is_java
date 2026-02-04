package personal_assignment1;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FeedingInfo {
    private int hour; // 급여 시간
    private String food; // 사료 종류
    private int gram; // 급여량
}
