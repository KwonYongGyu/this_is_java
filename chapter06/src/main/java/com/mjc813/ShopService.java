package com.mjc813;

public class ShopService {

//     private 접근 권한을 갖는 정적 필드 선언과 초기화
    // 클래스 내부에서 단 하나의 인스턴스를 생성(static 필드)
    private static ShopService singleton = new ShopService();

    // private 접근 권한을 갖는 생성자 선언
    // 외부에서 new를 사용할 수 없도록 생성자를 private로 제한
    private ShopService(){
    }

    // public 접근 권한을 갖는 정적 메소드 선언
    // 외부에서 객체를 요청할 때 미리 만든 인스턴스의 주소값을 리턴
    public static ShopService getInstance(){
        return singleton;
    }
//     클래스 변수1 = 클래스.getInstance();

}
