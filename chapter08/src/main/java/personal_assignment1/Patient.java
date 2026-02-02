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

    public abstract String getSpecies();
}