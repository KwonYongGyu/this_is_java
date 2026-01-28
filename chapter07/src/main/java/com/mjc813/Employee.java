package com.mjc813;

public final class Employee extends Person1{

        public Employee(String name) {
            super(name); // 부모 생성자를 통해 name 설정
        }
        @Override
        public void work() {
            System.out.println(getName() + "님은 제품을 생산합니다."); // Getter 사용
        }
//        System.out.println("제품을 생산합니다.");
    }

