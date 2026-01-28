package com.mjc813;

public class SmartPhone1 extends Phone1{
    // 생성자 선언
    SmartPhone1(String owner){
        // Phone 생성자 호출
        super(owner);
    }

    // 메소드 선언
    void internetSearch(){
        System.out.println("인터넷 검색을 합니다.");
    }
}
