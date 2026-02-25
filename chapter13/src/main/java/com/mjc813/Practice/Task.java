package com.mjc813.Practice;

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
        box.add(new Human("홍길동", 20));
        box.add(new Human("이순신", 40));

        // 꺼낼 때 Object 타입을 Human으로 강제 형변환해야 name에 접근이 가능하다.
        Human h = (Human) box.remove();
        System.out.println("이름: " + h.getName());

    }
}
