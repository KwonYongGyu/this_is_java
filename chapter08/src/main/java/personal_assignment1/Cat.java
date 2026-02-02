
package personal_assignment1;
import lombok.*;

import java.util.Locale;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class Cat extends Patient {
    public Cat(String name, String id, LocalDate now, Doctor doctor, PetOwner owner) {
        super(name, id, now, doctor, owner);
    }

    @Override
    public String getSpecies() {
        return "고양이";
    }
}