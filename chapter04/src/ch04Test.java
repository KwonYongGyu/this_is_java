import java.util.Scanner;

public class ch04Test

{
    public void number02() {
        // p.125
        String grade = "B";

        //Java 11 이전 문법
        int score1 = 0;
        switch (grade) {
            case "A":
                score1 = 100;
                break;
            case "B":
                int result = 100 - 20;
                score1 = result;
                break;
            default:
                score1 = 60;
        }
        System.out.println("score1: " + score1);

        // Java 13부터 가능
        int score2 = switch (grade) {
            case "A" -> 100;
            case "B" -> {
                int result = 100 - 20;
                yield result;
            }
            default -> 60;
        };
        System.out.println("score2: " + score2);
    }

    public void number03() {
        // p.128
        int sum = 0;
        int i;

        for (i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1~" + (i - 1) + "합 : " + sum);
    }

    public void number04() {
        //p.118 + p.131
        int num = (int) (Math.random() * 6) + 1;   // 주사위 번호 하나 뽑기

        if (num == 1) {
            System.out.println("1번이 나왔습니다.");
        } else if (num == 2) {
            System.out.println("2번이 나왔습니다.");
        } else if (num == 3) {
            System.out.println("3번이 나왔습니다.");
        } else if (num == 4) {
            System.out.println("4번이 나왔습니다.");
        } else if (num == 5) {
            System.out.println("5번이 나왔습니다.");
        } else {
            System.out.println("6번이 나왔습니다.");
        }
        //p.131
        int i = 1;
        while (i <= 10) {
            System.out.print(i + " ");
            i++;
        }
    }

    public void number05() {
        // p.129
        for (int m = 2; m <= 9; m++) {
            System.out.println("*** " + m + "단 ***");
            for (int n = 1; n <= 9; n++) {
                System.out.println(m + " x " + n + " = " + (m * n));
            }
        }
    }

    public void number06() {
        // 중첩 for문을 공부하고 스스로 코딩
    }

    public void number07() {
        // p.133
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int speed = 0;

        while (run) {
            System.out.println("-----------------");
            System.out.println("1. | 2. 감속 | 3. 중지");
            System.out.println("-----------------");
            System.out.println("선택: ");

            String strNum = scanner.nextLine();

            if (strNum.equals("1")) {
                speed++;
                System.out.println("현재 속도 = " + speed);
            } else if (strNum.equals("2")) {
                speed--;
                System.out.println("현재 속도 = " + speed);
            } else if (strNum.equals("3")) {
                run = false;
            }
        }
        System.out.println("프로그램 종료");
    }

    public void checknumber02() {
        String grade = "B";
        int score1 = switch (grade) {
            case "A" -> 100;
            case "B" -> {
                int result = 100 - 20;
                yield result;
            }
            default -> 60;
        };
        System.out.println("score1: " + score1);
    }

    public void checknumber03() {
        // for문을 사용해서 1부터 1--까지의 정수 중에서
        // 3의 배수의 총합을 출력하는 코드를 작성해라
        int sum = 0;
        int i = 0;
        for (i = 0; i <= 100; i++) {
            if (i % 3 == 0) {
                sum += i;

            }
        }
        System.out.println("3의 배수의 총합for입니다.: " + sum);
        int j = 0;
        while (j < 100) {
            if (j % 3 == 0) {
                sum += j;

            }
            j++;
        }
        System.out.println("3의 배수의 총합 while버전입니다.: " + sum);
    }

    public void checknumber04() {
        // while문과 Math.random() 메소드를 이용해서 두 개의 주사위를 던졌을때
        // 나오는 눈을 (눈1, 눈2)형태로 출력하고, 눈의 합이 5가 아니면 계속 주사위를 던지고,
        // 눈의 합이 5이면 실행을 멈추는 코드

        int num1 = (int) (Math.random() * 6) + 1;  // 첫 번째 주사위
        int num2 = (int) (Math.random() * 6) + 1;  // 두 번째 주사위
        int sum = num1 + num2;
        while (sum == 5) {
            System.out.println("눈1: " + num1 + "눈2: " + num2);

        }
    }

    public void checknumber05() {
        // 중첩 for문을 이용하여
    }
}
