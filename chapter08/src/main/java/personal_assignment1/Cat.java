package personal_assignment1;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class Cat extends Patient {
    public Cat(String name, String id, LocalDate now, Doctor doctor, PetOwner owner) {
        super(name, id, now, doctor, owner); // 부모 생성자 호출!
    }
}
