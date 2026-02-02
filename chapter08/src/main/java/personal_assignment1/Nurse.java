package personal_assignment1;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Nurse {
    private String name = "천장미";

    public void administerMedicine(Patient pet) {
        System.out.println("간호사 " + name + ": [" + pet.getSpecies() + "] "
                + pet.getName() + " 환자에게 약을 먹였습니다.");
    }

    public boolean allowVisitation(PetOwner visitor, Patient pet, int currentTime) {
        if (currentTime < 15 || currentTime > 20) {
            System.out.println("간호사: 면회 불가 (시간 아님)");
            return false;
        }
        // pet.getOwner()가 PetOwner 객체를 정상적으로 반환하는지 확인
        if (pet.getOwner() == null || !pet.getOwner().getName().equals(visitor.getName())) {
            System.out.println("간호사: 보호자 정보가 일치하지 않습니다.");
            return false;
        }
        if (pet.getVisitCount() >= 1) {
            System.out.println("간호사: 이미 면회를 마쳤습니다.");
            return false;
        }
        return true;
    }
}