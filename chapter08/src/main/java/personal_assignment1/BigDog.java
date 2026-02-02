package personal_assignment1;
import lombok.*;

import java.util.Locale;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class BigDog extends Patient {
    public BigDog(String name, String id, LocalDate now, Doctor doctor, PetOwner owner) {
        super(name, id, now, doctor, owner);
    }
}
