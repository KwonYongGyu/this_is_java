package personal_assignment1;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Patient {
    String name;    // 이름
    String id;      // 동물 종의 식별번호
    LocalDate admissionDate; // 입원날짜
    Doctor assignedDoctor; // 담당 의사
    LocalDate dischargeDate; // 퇴원날짜
    PetOwner owner; // 보호자
    int visitCount; // 면회 횟수

    Patient(String name, String id, LocalDate admissionDate, Doctor assignedDoctor, PetOwner owner) {
        this.name = name;
        this.id = id;
        this.admissionDate = admissionDate;
        this.assignedDoctor = assignedDoctor;
        this.owner = owner;
        this.visitCount = 0;
    }


}
