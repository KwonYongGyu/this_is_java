package com.mjc813;

public class NintendoGameInfo {
//    선생git 의 Html폴더의 0108-1.html 파일을 실행하면 닌텐도 게임 CRUD html/css/javascript 화면이 있습니다.
//    그 화면의 데이터들을 Java 클래스로 선언하고 객체들로 만들어 보세요.
    String gameName;
    String genre;
    String ageRating;
    int price;
    String imageUrl;


    NintendoGameInfo(String gameName, String genre, String ageRating
                    ,int price, String imageUrl){
        this.gameName = gameName;
        this.genre = genre;
        this.ageRating = ageRating;
        this.price = price;
        this.imageUrl = imageUrl;

    }
    public void displayInfo() {
        System.out.println("[" + genre + " | " + ageRating + "] " + gameName + " - 가격: " + price + "원");
    }

}
