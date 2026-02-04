package personal_assignment1;

import javax.print.Doc;
import java.net.DatagramPacket;
import java.time.LocalDate;

public class execution {
    public void AnimalHospitalExample() {
        AnimalHospital hospital = new AnimalHospital();
        Doctor doctorLee = new Doctor("이국종", " 고양이");
        Doctor doctorPark = new Doctor("박재갑", "소형견");
        Doctor doctorJang = new Doctor("장기려", "대형견");
        Doctor doctorSuk = new Doctor("석세일", "토끼");
        Doctor doctorNo = new Doctor("노성훈", "앵무새");
        Doctor doctorKim = new Doctor("김현수", "고슴도치");
        Doctor doctorChoi = new Doctor("최정한", "닭");


        // 2. 보호자 생성
        PetOwner owner1 = new PetOwner("김철수");
        PetOwner owner2 = new PetOwner("홍길동");
        PetOwner owner3 = new PetOwner("박대한");
        PetOwner owner4 = new PetOwner("이영희");
        PetOwner owner5 = new PetOwner("강재용");
        PetOwner owner6 = new PetOwner("고소미");
        PetOwner owner7 = new PetOwner("이치킨");


        // 3. 동물 환자 생성
        Cat cat = new Cat("나비", "C001", LocalDate.now(), doctorLee, owner1);
        cat.addFeeding(9, "생선캔", 50);
        SmallDog sdog = new SmallDog("초코", "S-D001", LocalDate.now(), doctorPark, owner2);
        SmallDog sdog1 = new SmallDog("마루", "S-D002", LocalDate.now(), doctorPark, owner3);
        BigDog bdog = new BigDog("보리", "B-D001", LocalDate.now(), doctorJang, owner3);
        Rabbit rabbit = new Rabbit("라떼", "R001", LocalDate.now(), doctorSuk, owner4);
        Parrot parrot = new Parrot("나나", "P001", LocalDate.now(), doctorNo, owner5);
        Hedgehog hedgehog = new Hedgehog("바늘이", "H001", LocalDate.now(), doctorKim, owner6);
        hedgehog.addFeeding(8, "밀웜", 10);
        hedgehog.addFeeding(20, "과일믹스", 15);

        Chicken chicken = new Chicken("꼬꼬", "CK001", LocalDate.now(), doctorChoi, owner7);
        chicken.addFeeding(7, "유기농사료", 100);
        // 4. 병원 입원 처리 닭과 고슴도치 추가
        hospital.admit(cat);
        hospital.admit(sdog);
        hospital.admit(sdog1);
        hospital.admit(bdog);
        hospital.admit(rabbit);
        hospital.admit(parrot);
        hospital.admit(hedgehog);
        hospital.admit(chicken);

        System.out.println("=== 병원 일과 시작 ===");

        // 5. 투약 업무 수행 + 병실 현황 출력
        hospital.giveMedicine();
        hospital.printRoomStatus();

        System.out.println("\n=== 면회 시나리오 ===");

        // 상황 A: 오전 10시 (면회 불가 시간)
        hospital.setCurrentTime(10);
        System.out.println("[오전 10시 면회 시도]");
        hospital.processVisitation(owner1, cat);

        // 상황 B: 오후 4시 (정상 면회)
        hospital.setCurrentTime(16);
        System.out.println("\n[오후 4시 첫 번째 면회 시도]");
        hospital.processVisitation(owner1, cat); // 나비 면회 성공

        hospital.setCurrentTime(17);
        System.out.println("\n[오후 5시 면회 실시]");
        hospital.processVisitation(owner6, hedgehog);

        // 상황 C: 같은 동물을 다시 면회 시도 (동물당 하루 1회 제한)
        System.out.println("\n[오후 5시 같은 동물 재면회 시도]");
        hospital.setCurrentTime(17);
        hospital.processVisitation(owner1, cat); // 실패 (나비는 이미 면회함)

        // 상황 D: 주인이 다른 반려동물을 면회 시도 (주인 횟수 제한 없음)
        System.out.println("\n[오후 6시 다른 반려동물 면회 시도]");
        hospital.setCurrentTime(18);
        hospital.processVisitation(owner3, bdog); // 성공 (보리는 오늘 첫 면회)
    }
}

