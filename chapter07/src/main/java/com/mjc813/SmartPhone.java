package com.mjc813;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//@AllArgsConstructor
public class SmartPhone extends Phone {
    // 필드 선언
//    public boolean wifi;

    public SmartPhone(String model, String color) {
        super(model, color);
//        this.setModel(model);
//        this.setColor(color);
        System.out.println("SmartPhone(String model, String color) 생성자 실행됨");

//        this.setWifi(wifi);
    }
//    }
//
//    public void setWifi(boolean wifi){
//        this.wifi = wifi;
////        setWifi(wifi);
//        System.out.println("와이파이 상태를 변경했습니다.");
//    }
//    public void internet(){
//
//        System.out.println("인터넷에 연결합니다.");
//    }
}
