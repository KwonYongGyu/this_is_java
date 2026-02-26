package com.mjc813.bookExample;


import java.util.*;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.List;

public class Chapter15 {
    public void ArrayListExample(){
        //ArrayList 컬랙션 생성
        List<Board> list = new ArrayList<>();

        // 객체 추가
        list.add(new Board("제목1", "내용1", "글쓴이1"));
        list.add(new Board("제목2", "내용2", "글쓴이2"));
        list.add(new Board("제목3", "내용3", "글쓴이3"));
        list.add(new Board("제목4", "내용4", "글쓴이4"));
        list.add(new Board("제목5", "내용5", "글쓴이5"));

        // 저장된 총 객체 수 얻기
        int size = list.size();
        System.out.println("총 객체 수: " + size);
        System.out.println();

        // 특정 인텍스의 객체 가져오기
        Board board = list.get(2);
        System.out.println(board.getSubject() + "\t" + board.getContent()
                            + "\t" + board.getWriter());
        System.out.println();

        // 모든 객체를 하나씩 가져오기
        for(int i =0; i< list.size(); i++) {
            Board b = list.get(i);
            System.out.println(b.getSubject() + "\t" + b.getContent()
                                + "\t" + b.getWriter());
        }
        System.out.println();

        // 객체 삭제
        list.remove(2);
        list.remove(2);

        // 향상된 for 문으로 모든 객체를 하나씩 가져오기
        for(Board b : list) {
            System.out.println(b.getSubject() + "\t" + b.getContent()
                                + "\t" + b.getWriter());
        }
        System.out.println();
    }
    public void LinkedListExample(){
        // ArrayList 컬렉션 객체 생성
        List<String> list1 = new ArrayList<String>();

        // LinkedList 컬렉션 객체 생성
        List<String> list2 = new LinkedList<String>();

        // 시작 시간과 끝 시간을 저장할 변수 선언
        long startTime;
        long endTime;

        // ArrayList 컬렉션에 저장하는 시간 측정
        startTime = System.nanoTime();
        for(int i = 0; i < 10000; i++) {
            list1.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "ArrayList 걸린 시간: ",
                (endTime - startTime) );

        // LinkedList 컬렉션에 저장하는 시간 측정
        startTime = System.nanoTime();
        for(int i = 0; i < 10000; i++) {
            list2.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "LinkedList 걸린 시간: ",
                (endTime - startTime) );
        System.out.println();
    }

    public void HashMapExample() {
        // Map 컬렉션 생성
        Map<String, Integer> map = new HashMap<>();

        // 객체 저장
        map.put("신용권", 85);
        map.put("홍길동", 90);
        map.put("동장군", 80);
        map.put("홍길동", 95); // 키가 같기때문에 제읾 마지막에 저장한 값만 저장
        System.out.println("총 Entry 수: " + map.size());
        System.out.println();

        // 키로 값 얻기
        String key = "홍길동";
        int value = map.get(key);   // 키를 매개값으로 주면 값을 리턴
        System.out.println(key + ": " + value);
        System.out.println();

        // 키 Set 컬렉션 얻고, 반복해서 키와 값을 얻기
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            String k = keyIterator.next();
            Integer v = map.get(k);
            System.out.println(k + ": " + v);
        }
        System.out.println();

        // 엔트리 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        Set<Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Entry<String, Integer> entry = entryIterator.next();
            String k =entry.getKey();
            Integer v = entry.getValue();
            System.out.println();
        }
        System.out.println();

        // 키로 엔트리 삭제
        map.remove("홍길동");
        System.out.println("총 Entry 수: " + map.size());
        System.out.println();
    }

    public void VectorExample(){
        // Vector 컬렉션 생성
        List<Board> list = new Vector<>();

        // 작업 스레드 객체 생성
        Thread threadA = new Thread() {
            @Override
            public void run(){
                // 객체 1000개 추가
                for(int i = 1; i <=1000; i++) {
                    list.add(new Board("제목"+ i,"내용"+i, "글쓴이"+i));

                }
            }
        };

                // 작업 스레드 객체 생성
                Thread threadB = new Thread() {
                    @Override
                    public void run() {
                        // 객체 1000개 추가
                        for(int i = 1001; i <= 2000; i++){
                            list.add(new Board("제목"+i, "내용"+i, "글쓴이"+i));
                        }
                    }
                };

                // 작업 스레드 실행
                threadA.start();
                threadB.start(); // 동기 방식이라서 A가 끝나지 않더라도 B 실행

                // 작업 스레드들이 모두 종료될 때까지 메인 스레드를 기다리게 함
                try {
                    threadA.join();
                    threadB.join();
                } catch (Exception e) {
            }
                // 저장된 총 객체 수 얻기
                int size = list.size();
                System.out.println("총 객체 수: " +size);
                System.out.println();
        }

        public void HashSetExample(){
        // HashSet 컬렉션 생성
            Set<String> set = new HashSet<String>();

            // 객체 저장
            set.add("Java");
            set.add("JDBC");
            set.add("JSP");
            set.add("Java"); // 중복 객체이므로 저장하지 않음
            set.add("Spring");

            // 저장된 객체 수 출력
            int size = set.size();
            System.out.println("총 객체 수: " + size);
        }

        public void HashSetExample2(){
        // HashSet 컬렉션 생성
            Set<Member> set = new HashSet<>();

            // Member 객체 저장
            set.add(new Member("홍길동", 30));
            set.add(new Member("홍길동", 30)); // 인스턴스는 다르지만 동등 객체이므로 객체 1개만 저장

            // 저장된 객체 수 출력
            System.out.println("총 객체 수 : " + set.size());
        }

    }

