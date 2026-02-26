package com.mjc813.practice;

public class Util {
    // 제너릭 메서드 getValue 정의
    public static <K, V, P extends Pair<K, V>> V getValue(P pair, K key) {
        // P는 반드시 Pair이거나 Pair를 상속받은 자식클래스여야만 한다.
        // 입력받은 pair의 키와 찾고자 하는 key가 일치하는지 확인
        if(pair.getKey().equals(key)) {
            return pair.getValue(); // 일치하면 값 리턴
        } else {
            return null; // 일치하지 않으면 null 리턴
        }
    }
}
