package com.mjc813;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Setter
@Getter
//@AllArgsConstructor
public class Phone {
// 필드 선언
    public String model;
    public String color;

    public Phone() {
        System.out.println("Phone() 생성자 실행");
    }

    public Phone(String model, String color){
        this.setModel(model);
        this.setColor(color);
        System.out.println("Phone(String model, String color) 생성자 실행");
    }
    // 메소드 선언
//    public void bell(){
//        System.out.println("벨이 울립니다.");
//    }
//
//    public void sendVoice(String message){
//        System.out.println("자기: "+ message);
//    }
//    public void receiveVoice(String message){
//        System.out.println("상대방: " + message);
//    }
//
//    public void hangUp(){
//        System.out.println("전화를 끊습니다.");
//    }

}
