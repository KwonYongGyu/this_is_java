package personal_assignment1;

import java.time.LocalDate;

public class execution {
    public void AnimalHospitalExample() {
        AnimalHospital hospital = new AnimalHospital();
        Doctor doctorLee = new Doctor("이국종");

        // 2. 보호자 생성
        PetOwner owner1 = new PetOwner("철수");

        // 3. 동물 환자 생성 (철수의 반려동물 2마리)
        Cat cat = new Cat("나비", "C001", LocalDate.now(), doctorLee, null, owner1, 0);
        SmallDog dog = new SmallDog("초코", "D001", LocalDate.now(), doctorLee, null, owner1, 0);

        // 4. 병원 입원 처리
        hospital.admit(cat);
        hospital.admit(dog);

        System.out.println("=== 병원 일과 시작 ===");

        // 5. 투약 업무 수행
        hospital.giveMedicine();

        System.out.println("\n=== 면회 시나리오 ===");

        // 상황 A: 오전 10시 (면회 시간 아님)
        hospital.setCurrentTime(10);
        System.out.println("[오전 10시 면회 시도]");
        hospital.processVisitation(owner1, cat);

        // 상황 B: 오후 4시 (정상 면회)
        hospital.setCurrentTime(16);
        System.out.println("\n[오후 4시 첫 번째 면회 시도]");
        hospital.processVisitation(owner1, cat); // 나비 면회 성공

        // 상황 C: 같은 동물을 다시 면회 시도 (동물당 하루 1회 제한)
        System.out.println("\n[오후 5시 같은 동물 재면회 시도]");
        hospital.setCurrentTime(17);
        hospital.processVisitation(owner1, cat); // 실패 (나비는 이미 면회함)

        // 상황 D: 주인이 다른 반려동물을 면회 시도 (주인 횟수 제한 없음)
        System.out.println("\n[오후 6시 다른 반려동물 면회 시도]");
        hospital.setCurrentTime(18);
        hospital.processVisitation(owner1, dog); // 성공 (초코는 오늘 첫 면회)
    }
}

