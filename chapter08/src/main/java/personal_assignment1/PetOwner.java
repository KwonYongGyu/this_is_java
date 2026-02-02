package personal_assignment1;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PetOwner {
    private String name;

    public void visit(Patient pet) {
        System.out.println(this.name + "님이 반려동물 [" + pet.getName() + "]와(과) 면회하고 있습니다.");
    }
}