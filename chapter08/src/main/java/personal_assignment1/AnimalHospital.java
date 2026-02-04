package personal_assignment1;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalHospital {
    private int currentTime;             // 현재시간
    private Patient[] patients = new Patient[100]; // 환자들 배열
    private Doctor[] doctors = new Doctor[7];    // 의사들 배열 5 -> 7로 의사 정원 확대
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

    // 병실 관리 및 식단
    public void printRoomStatus() {
        System.out.println("\n========= 병실별 입원 현황 및 식단표 =========");
        String[] speciesList = {"고양이", "소형견", "대형견", "토끼", "앵무새", "고슴도치", "닭"};

        for (String species : speciesList) {
            System.out.println("[" + species + " 병실]");
            boolean isEmpty = true;
            for (int i = 0; i < patientCount; i++) {
                if (patients[i].getSpecies().equals(species)) {
                    Patient p = patients[i];
                    System.out.println(" ▶ 환자명: " + patients[i].getName() + " (담당의: " + patients[i].getAssignedDoctor().getName() + ")");
                    System.out.print("   식단 계획: ");
                    if (p.getDietCount() == 0) {
                        System.out.print("설정된 식단 없음");
                    } else {
                        for (int j = 0; j < p.getDietCount(); j++) {
                            FeedingInfo info = p.getDietPlan()[j];
                            System.out.print(info.toString() + " ");
                        }
                    }
                    System.out.println(); // 한 환자의 식단 출력이 끝나면 줄바꿈
                    isEmpty = false;
                }
            }
            if (isEmpty) System.out.println("   (현재 입원 환자 없음)");
        }
        System.out.println("===========================================");
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