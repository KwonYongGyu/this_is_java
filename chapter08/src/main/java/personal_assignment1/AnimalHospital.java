package personal_assignment1;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalHospital {
    private int currentTime;             // 현재시간
    private Patient[] patients = new Patient[100]; // 환자들 배열
    private Doctor[] doctors = new Doctor[5];    // 의사들 배열
    private Nurse mainNurse = new Nurse();       // 주인공 간호사
    private int patientCount = 0;

    // 입원
    public boolean admit(Patient pet) {
        if (patientCount < 100) {
            patients[patientCount++] = pet;
            return true;
        }
        return false;
    }
    public void giveMedicine() {
        for (int i = 0; i < patientCount; i++) {
            mainNurse.administerMedicine(patients[i]);
        }

    }
    public void processVisitation(PetOwner owner, Patient pet) {
        // 간호사가 면회 조건을 체크 (시간, 소유주 일치 여부 등)
        if (mainNurse.allowVisitation(owner, pet, currentTime)) {
            owner.visit(pet);
            // 면회 성공 시 횟수 증가
            pet.setVisitCount(pet.getVisitCount() + 1);
        }
    }
}