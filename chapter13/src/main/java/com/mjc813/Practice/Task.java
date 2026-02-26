package com.mjc813.practice;

public class Task {
    public void task1(){
        Packaging box = new Packaging();

        // 1. String 2~3개 add/remove
        box.add("사과");
        box.add("바나나");
        box.add("딸기");
        String str = (String) box.remove(); // String 형변환이 필수이다.
        System.out.println("꺼낸 값: " + str);

        // 2. Human 2~3개 add/remove
        box.add(new Human(20));
        box.add(new Human(40));

        // 꺼낼 때 Object 타입을 Human으로 강제 형변환해야 name에 접근이 가능하다.
        Human h = (Human) box.remove();
        System.out.println("이름: " + h.getName());

    }
    public void task3(){
        Pair<String, Integer> pair = new Pair<>("홍길동" , 35);
        Integer age = Util.getValue(pair, "홍길동");
        System.out.println(age);

        ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원", 20);
        Integer childAge = Util.getValue(childPair, "홍삼순");
        System.out.println(childAge);

        /*OtherPair<String, Integer> otherPair = new OtherPair<>("홍삼원", 20);
        // OtherPair는 Pair를 상속하지 않으므로 컴파일 에러가 발생
        int otherAge = Util.getValue(otherPair, "홍삼원");
        System.out.println(otherAge); */
    }
}
