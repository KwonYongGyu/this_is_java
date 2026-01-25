package com.mjc813;

public class RpgGameCharacterInfo {
//    String inputCharacter;
    String name;
    String job;
    String gender;
    String birthDate;
    int hp;
    int mp;
    int str;
    int intStat;
    int dex;
    int lux;
//    String attackTarget;
//    String STRAttack;
//    String INTAttack;
//    String characterCatalog;


    RpgGameCharacterInfo(String name, String job, String gender, String birthDate
            ,int hp, int mp, int str, int intState, int dex, int lux){
        this.name = name;
        this.job = job;
        this.gender = gender;
        this.birthDate = birthDate;
        this.hp = hp;
        this.mp = mp;
        this.str = str;
        this.intStat = intState;
        this.dex = dex;
        this.lux = lux;
    }

    public void displayCharacter(){
        System.out.printf("[%s] 이름: %s | 성별: %s | HP: %d | MP: %d | 생일: %s\n",
                job, name, gender, hp, mp, birthDate);
    }



}
