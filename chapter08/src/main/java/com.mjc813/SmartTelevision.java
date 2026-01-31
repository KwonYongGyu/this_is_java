package com.mjc813;


public class SmartTelevision implements RemoteControl1, Searchable{
    //turnOn() 추상 메소드 오버라이딩
    @Override
    public void turnOn(){
        System.out.println("TV를 켭니다.");
    }

    //turnoff() 추상 메소드 오버라이딩
    @Override
    public void turnOff(){
        System.out.println("TV를 끕니다.");
    }

    //search() 추상 메소드 오버라이딩
    public void search(String url){
        System.out.println(url + "검색합니다.");
    }
}
