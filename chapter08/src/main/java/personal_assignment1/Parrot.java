package personal_assignment1;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class Parrot extends Patient {
    public Parrot(String name, String id, LocalDate now, Doctor doctor, PetOwner owner) {
        super(name, id, now, doctor, owner);
    }

    @Override
    public String getSpecies() {
        return "앵무새";
    }
}
