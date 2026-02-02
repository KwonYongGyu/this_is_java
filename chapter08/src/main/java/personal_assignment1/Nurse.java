package personal_assignment1;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor  // 기본 생성자 Nurse() 자동 생성
@AllArgsConstructor // 모든 필드 생성자 Nurse(String name) 자동 생성
@ToString
public class Nurse {
    private String name ="천장미";

    // 1. 약을 준다
    public void administerMedicine(Patient pet) {
        System.out.println("간호사 " + name + ": " + pet.getName() + "(ID: " + pet.getId() + ") 환자에게 약을 먹였습니다.");
    }

    // 2. 면회를 허락한다
    public boolean allowVisitation(PetOwner visitor, Patient pet, int currentTime) {
        // 시간 조건 (15~20시)
        if (currentTime < 15 || currentTime > 20) {
            System.out.println("간호사: 면회는 불가합니다. (사유: 면회시간이 아닙니다. 면회시간은 15~20시 입니다.)");
            return false;
        }

        // 보호자 일치 확인
        if (pet.getOwner() == null || !pet.getOwner().getName().equals(visitor.getName())) {
            System.out.println("간호사: 해당 환자의 보호자가 아닙니다.");
            return false;
        }

        if (pet.getVisitCount() >= 1) {
            System.out.println("간호사: 이미 오늘 면회를 마쳤습니다.");
            return false;
        }

        System.out.println("간호사: 확인되었습니다. 면회를 허락합니다.");
        return true;
    }

    // --- 헬퍼 메서드들 ---
    private int getVisitCount(Object pet) {
        if (pet instanceof Cat) return ((Cat) pet).getVisitCount();
        if (pet instanceof Parrot) return ((Parrot) pet).getVisitCount();
        if (pet instanceof BigDog) return ((BigDog) pet).getVisitCount();
        if (pet instanceof SmallDog) return ((SmallDog) pet).getVisitCount();
        if (pet instanceof Rabbit) return ((Rabbit) pet).getVisitCount();
        return 0;
    }

    private String getOwnerName(Object pet) {
        if (pet instanceof Cat) return ((Cat) pet).getOwner().getName();
        if (pet instanceof Parrot) return ((Parrot) pet).getOwner().getName();
        if (pet instanceof BigDog) return ((BigDog) pet).getOwner().getName();
        if (pet instanceof SmallDog) return ((SmallDog) pet).getOwner().getName();
        if (pet instanceof Rabbit) return ((Rabbit) pet).getOwner().getName();
        return "";
    }
}