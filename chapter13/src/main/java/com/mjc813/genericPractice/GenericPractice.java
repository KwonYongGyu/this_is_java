package com.mjc813.genericPractice;

import java.util.HashMap;
import java.util.Map;

public class GenericPractice <K, V> {
    // 내부 저장소
    private Map<K, V> storage = new HashMap<>();

    // m1. 키, 갑 구조의 데이터를 새로 추가하거나 또는
    // 자료들 중에서 이미 키 가 존재하면 자료의 값을 수정한다.
    public void put(K key, V value) {
        storage.put(key, value);
    }

    // m2. 키에 해당하는 값 가져오기
    public V get(K key) {
        return storage.get(key);
    }

    // m3. 키에 해당하는 값을 삭제
    public void remove(K key){
        storage.remove(key);
    }

    // m4. 자료들이 몇개 있는지 개수를 리턴한다.
    public int size() {
        return storage.size();
    }

    // m5.change (키1, 키2) 라는 메소드는 키1의 값과 키2의 값을 서로 교환한다.
    public void chane(K key1, K key2) {
        if(storage.containsKey(key1) && storage.containsKey(key2)) {
            V temp = storage.get(key1); // key1의 값을 임시 저장
            storage.put(key1, storage.get(key2));   // key2의 값을 key1 자리에 넣기
            storage.put(key2, temp); // 임시 저장했던 값을 key2 자리에 넣기
        }
    }

}
