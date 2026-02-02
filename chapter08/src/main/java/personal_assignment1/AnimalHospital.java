package personal_assignment1;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AnimalHospital {
    private int currentTime;             // 현재시간
    private Object[] patients = new Object[100]; // 환자들 배열
    private Doctor[] doctors = new Doctor[5];    // 의사들 배열
    private Nurse mainNurse = new Nurse();       // 주인공 간호사
    private int patientCount = 0;

    // 입원
    public boolean admit(Object pet) {
        if (patientCount < 100) {
            patients[patientCount++] = pet;
            return true;
        }
        return false;
    }

    // 약 주기
    public void giveMedicine() {
        for (int i = 0; i < patientCount; i++) {
            Object p = patients[i];
            if (p instanceof Cat) mainNurse.administerMedicine(p, ((Cat)p).getName(), ((Cat)p).getId());
            else if (p instanceof Parrot) mainNurse.administerMedicine(p, ((Parrot)p).getName(), ((Parrot)p).getId());
            else if (p instanceof BigDog) mainNurse.administerMedicine(p, ((BigDog)p).getName(), ((BigDog)p).getId());
            else if (p instanceof SmallDog) mainNurse.administerMedicine(p, ((SmallDog)p).getName(), ((SmallDog)p).getId());
            else if (p instanceof Rabbit) mainNurse.administerMedicine(p, ((Rabbit)p).getName(), ((Rabbit)p).getId());
        }
    }

    // 면회
    public void processVisitation(PetOwner owner, Object pet) {
        // 간호사가 면회 조건을 체크하여 허락하면 면회 진행
        if (mainNurse.allowVisitation(owner, pet, currentTime)) {
            owner.visit(pet);
            updateVisitCount(pet); // 면회 완료 후 횟수 업데이트
        }
    }

    // 면회 횟수 업데이트
    private void updateVisitCount(Object pet) {
        if (pet instanceof Cat) ((Cat) pet).setVisitCount(1);
        else if (pet instanceof Parrot) ((Parrot) pet).setVisitCount(1);
        else if (pet instanceof BigDog) ((BigDog) pet).setVisitCount(1);
        else if (pet instanceof SmallDog) ((SmallDog) pet).setVisitCount(1);
        else if (pet instanceof Rabbit) ((Rabbit) pet).setVisitCount(1);
    }
}