package personal_assignment1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString

public class Hedgehog extends Patient {
    public Hedgehog(String name, String id, LocalDate now, Doctor doctor, PetOwner owner) {
        super(name, id, now, doctor, owner);
    }

    @Override
    public String getSpecies() {
        return "고슴도치";
    }
}
