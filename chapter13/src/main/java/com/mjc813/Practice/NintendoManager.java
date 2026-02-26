package com.mjc813.practice;

import java.util.ArrayList;
import java.util.List;

public class NintendoManager implements CRUD<NintendoGame>{

    // 게임들을 저장할 명단(List)
    private List<NintendoGame> storage = new ArrayList<>();

    @Override
    public void add(NintendoGame item) {
        storage.add(item); // 리스트 맨 뒤에 추가
    }

    @Override
    public int size() {
        return storage.size(); // 현재 등록된 게임 수
    }

    @Override
    public NintendoGame set(int index, NintendoGame item) {
        // index 위치의 데이터를 item으로 교체하고 원래 데이터를 리턴
        return storage.set(index, item);
    }
    @Override
    public NintendoGame remove(int index) {
        // index 위치의 데이터를 삭제하고, 삭제된 데이터를 리턴
        return storage.remove(index);
    }

    @Override
    public com.mjc813.practice.NintendoGame set(int index) {
        return null;
    }


    @Override
    public NintendoGame get(int index) {
        return storage.get(index); // 특정 위치의 게임 정보 가져오기
    }

    @Override
    public String getJson(int index) {
        NintendoGame game = storage.get(index);
        return String.format("{\"name\":\"%s\", \"grade\":\"%s\", \"price\":%d}",
                game.getName(), game.getGrade(), game.getPrice());
    }

    @Override
    public String getJsonAllItems() {
        StringBuilder sb = new StringBuilder("[");
        for(int i =0; i < storage.size(); i++) {
            sb.append(getJson(i));
            if (i < storage.size() -1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
