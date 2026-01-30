package personal_assignment1;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PetOwner {
    private String name;
    public void visit(Object pet){
    // 주인이 동물을 면회한다.
        System.out.println(name + "님이 반려동물과 면회하고 있습니다.");
    }

}
