package com.mjc813.Practice;

import javax.swing.plaf.synth.SynthUI;

public class Main {
    public static void main(String[] args) {
        NintendoManager manager = new NintendoManager();

        // 추가
        manager.add(new NintendoGame("마리오 카트", Grade.All, 64800));
        manager.add(new NintendoGame("젤다의 전설", Grade.AGE12_OVER, 74800));

        // 조회
        System.out.println("전체 게임 수: " + manager.size());
        System.out.println("0번 게임: " + manager.get(0).getName());

        // Json 확인
        System.out.println("전체 Json: " + manager.getJsonAllItems());


    }
}
