package personal_assignment1;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class Patient {
    private String name;
    private String id;
    private LocalDate admissionDate;
    private Doctor assignedDoctor;
    private LocalDate dischargeDate;
    private PetOwner owner;
    private int visitCount;

    // 사료를 주는 식단 계획 추가
    private FeedingInfo[] dietPlan = new FeedingInfo[10];
    // 식단의 개수
    private int dietCount = 0;

    public Patient(String name, String id, LocalDate admissionDate, Doctor assignedDoctor, PetOwner owner) {
        this.name = name;
        this.id = id;
        this.admissionDate = admissionDate;
        this.assignedDoctor = assignedDoctor;
        this.owner = owner;
//        this.assignedDoctor = assignedDoctor;
//        this.owner = owner;
        this.visitCount = 0;
    }

    public void addFeeding(int hour, String food, int gram) {
        this.dietPlan[dietCount++] = new FeedingInfo(hour, food, gram);
    }

    public abstract String getSpecies();
}