package personal_assignment1;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class Rabbit extends Patient {
    public Rabbit(String name, String id, LocalDate now, Doctor doctor, PetOwner owner) {
        super(name, id, now, doctor, owner);
    }
}
