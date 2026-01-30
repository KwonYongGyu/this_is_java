package personal_assignment1;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cat {
    private String name;    // 이름
    private String id;      // 동물 종의 식별번호
    private LocalDate admissionDate; // 입원날짜
    private Doctor assignedDoctor; // 담당 의사
    private LocalDate dischargeDate; // 퇴원날짜
    private PetOwner owner; // 보호자
    private int visitCount; // 면회 횟수
}
