package com.mjc813.bookExample;


import javax.annotation.processing.SupportedSourceVersion;
import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.*;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.TreeMap;


public class Chapter15 {
    public void ArrayListExample() {
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
        for (int i = 0; i < list.size(); i++) {
            Board b = list.get(i);
            System.out.println(b.getSubject() + "\t" + b.getContent()
                    + "\t" + b.getWriter());
        }
        System.out.println();

        // 객체 삭제
        list.remove(2);
        list.remove(2);

        // 향상된 for 문으로 모든 객체를 하나씩 가져오기
        for (Board b : list) {
            System.out.println(b.getSubject() + "\t" + b.getContent()
                    + "\t" + b.getWriter());
        }
        System.out.println();
    }

    public void LinkedListExample() {
        // ArrayList 컬렉션 객체 생성
        List<String> list1 = new ArrayList<String>();

        // LinkedList 컬렉션 객체 생성
        List<String> list2 = new LinkedList<String>();

        // 시작 시간과 끝 시간을 저장할 변수 선언
        long startTime;
        long endTime;

        // ArrayList 컬렉션에 저장하는 시간 측정
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list1.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "ArrayList 걸린 시간: ",
                (endTime - startTime));

        // LinkedList 컬렉션에 저장하는 시간 측정
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list2.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "LinkedList 걸린 시간: ",
                (endTime - startTime));
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
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println();
        }
        System.out.println();

        // 키로 엔트리 삭제
        map.remove("홍길동");
        System.out.println("총 Entry 수: " + map.size());
        System.out.println();
    }

    public void VectorExample() {
        // Vector 컬렉션 생성
        List<Board> list = new Vector<>();

        // 작업 스레드 객체 생성
        Thread threadA = new Thread() {
            @Override
            public void run() {
                // 객체 1000개 추가
                for (int i = 1; i <= 1000; i++) {
                    list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));

                }
            }
        };

        // 작업 스레드 객체 생성
        Thread threadB = new Thread() {
            @Override
            public void run() {
                // 객체 1000개 추가
                for (int i = 1001; i <= 2000; i++) {
                    list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
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
        System.out.println("총 객체 수: " + size);
        System.out.println();
    }

    public void HashSetExample() {
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

    public void HashSetExample2() {
        // HashSet 컬렉션 생성
        Set<Member> set = new HashSet<>();

        // Member 객체 저장
        set.add(new Member("홍길동", 30));
        set.add(new Member("홍길동", 30)); // 인스턴스는 다르지만 동등 객체이므로 객체 1개만 저장

        // 저장된 객체 수 출력
        System.out.println("총 객체 수 : " + set.size());
    }

    public void HashMapExample2() {
        // Map 컬렉션 생성
        Map<String, Integer> map = new HashMap<>();

        // 객체 저장
        map.put("신용권", 85);
        map.put("홍길동", 90); // 키가 같기 때문에 마지막에 저장한 값만 저장
        map.put("동장군", 80);
        map.put("홍길동", 95); // 키가 같기 때문에 마지막에 저장한 값만 저장
        System.out.println("총 Entry 수: " + map.size());
        System.out.println();

        // 키로 값 얻기
        String key = "홍길동";
        int value = map.get(key); // 키를 매개값으로 주면 값을 리턴
        System.out.println(key + " : " + value);
        System.out.println();

        // 키 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator(); // 키를 반복하기 위해 반복자를 얻음
        while (keyIterator.hasNext()) {
            String k = keyIterator.next();
            Integer v = map.get(k);
            System.out.println(k + " : " + v);
        }
        System.out.println();

        // 엔트리 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        Set<Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator(); // 엔트리를 반복하기 위해 반복자를 얻음
        while (entryIterator.hasNext()) {
            Entry<String, Integer> entry = entryIterator.next();
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + " : " + v);
        }
        System.out.println();

        // 키로 엔트리 삭제
        map.remove("홍길동");
        System.out.println("총 Entry 수: " + map.size());
        System.out.println();
    }

    public void HashtableExample() {
        // Hashtable 컬렉션 생성
        Map<String, Integer> map = new Hashtable<>();

        // 작업 스레드 객체 생성
        Thread threadA = new Thread() {
            @Override
            public void run() {
                // 엔트리 1000개 추가
                for (int i = 1; i <= 1000; i++) {
                    map.put(String.valueOf(i), i);
                }
            }
        };

        // 작업 스레드 객체 생성
        Thread threadB = new Thread() {
            @Override
            public void run() {
                // 엔트리 1000개 추가
                for (int i = 1001; i <= 2000; i++) {
                    map.put(String.valueOf(i), i);
                }
            }
        };

        // 작업 스레드 실행
        threadA.start();
        threadB.start();

        // 작업 스레드들이 모두 종료될 때까지 메인 스레드를 기다리게 함
        try {
            threadA.join();
            threadB.join();
        } catch (Exception e) {
        }

        // 저장된 총 엔트리 수 얻기
        int size = map.size();
        System.out.println("총 엔트리 수: " + size);
        System.out.println();
    }

    public void TreeSetExample() {
        // TreeSet 컬렉션 생성
        TreeSet<Integer> scores = new TreeSet<>();

        // Integer 객체 저장
        scores.add(87);
        scores.add(98);
        scores.add(75);
        scores.add(95);
        scores.add(80);

        // 정렬된 Integer 객체를 하나씩 가져오기
        for (Integer s : scores) {
            System.out.print(s + " ");
        }
        System.out.println("\n");

        // 특정 Integer 객체를 가져오기
        System.out.println("가장 낮은 점수: " + scores.first());
        System.out.println("가장 높은 점수: " + scores.last());
        System.out.println("95점 아래 점수: " + scores.lower(95));
        System.out.println("95점이거나 바로 아래 점수: " + scores.floor(95));
        System.out.println("85점이거나 바로 위의 점수: " + scores.ceiling(85) + "\n");

        // 내림차순으로 정렬하기
        NavigableSet<Integer> descendingScores = scores.descendingSet();
        for (Integer s : descendingScores) {
            System.out.print(s + " ");
        }
        System.out.println("\n");

        // 범위 검색 ( 80 <= )
        NavigableSet<Integer> rangeSet = scores.tailSet(80, true);
        for (Integer s : rangeSet) {
            System.out.print(s + " ");
        }
        System.out.println("\n");

        // 범위 탐색 ( 80 <= scores < 90)
        rangeSet = scores.subSet(80, true, 90, false);
        for (Integer s : rangeSet) {
            System.out.print(s + " ");
        }

    }

    public void TreeMapExample() {
        // TreeMap 컬렉션 생성
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // 엔트리 지정
        treeMap.put("apple", 10);
        treeMap.put("forever", 60);
        treeMap.put("description", 40);
        treeMap.put("ever", 50);
        treeMap.put("zoo", 80);
        treeMap.put("base", 20);
        treeMap.put("guess", 70);
        treeMap.put("cherry", 30);

        // 정렬된 엔트리를 하나씩 가져오기
        Set<Entry<String, Integer>> entrySet = treeMap.entrySet();
        for (Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println();

        // 특정 키에 대한 값 가져오기
        Entry<String, Integer> entry = null;
        entry = treeMap.firstEntry();
        System.out.println("제일 앞 단어: " + entry.getKey() + "-" + entry.getValue());
        entry = treeMap.lastEntry();
        System.out.println("제일 뒤 단어: " + entry.getKey() + "-" + entry.getValue());
        entry = treeMap.lowerEntry("ever");
        System.out.println("ever 앞 단어: " + entry.getKey() + "-" + entry.getValue() + "\n");

        // 내림차순으로 정렬하기
        NavigableMap<String, Integer> descendingMap = treeMap.descendingMap();
        Set<Entry<String, Integer>> descendingEntrySet = descendingMap.entrySet();
        for (Entry<String, Integer> e : descendingEntrySet) {
            System.out.println(e.getKey() + "-" + e.getValue());
        }
        System.out.println();

        // 범위 검색
        System.out.println("[c~h 사이의 단어 검색]");
        NavigableMap<String, Integer> rangeMap = treeMap.subMap("c", true, "h", false);
        for (Entry<String, Integer> e : rangeMap.entrySet()) {
            System.out.println(e.getKey() + "-" + e.getValue());
        }
    }

    public void ComparableExample() {
        // TreeSet 컬렉션 생성
        TreeSet<Person> treeSet = new TreeSet<Person>();

        // 객체 저장
        treeSet.add(new Person("홍길동", 45));
        treeSet.add(new Person("감자바", 25));
        treeSet.add(new Person("박지원", 31));

        // 객체를 하나씩 가져오기
        for (Person person : treeSet) {
            System.out.println(person.name + ":" + person.age);
        }
    }

    public void ComparatorExample() {
        // 비교자를 제공한 TreeSet 컬렉션 생성
        TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new FruitComparator());

        // 객체 저장
        treeSet.add(new Fruit("포도", 3000));
        treeSet.add(new Fruit("수박", 10000));
        treeSet.add(new Fruit("딸기", 6000));

        // 객체를 하나씩 가져오기
        for (Fruit fruit : treeSet) {
            System.out.println(fruit.name + ":" + fruit.price);
        }
    }

    public void StackExample() {
        // Stack 컬렉션 생성
        Stack<Coin> coinBox = new Stack<Coin>();

        // 동전 넣기
        coinBox.push(new Coin(100));
        coinBox.push(new Coin(50));
        coinBox.push(new Coin(500));
        coinBox.push(new Coin(10));

        // 동전을 하나씩 꺼내기
        while (!coinBox.isEmpty()) { // 비어있지 않다면 반복
            Coin coin = coinBox.pop();
            System.out.println("꺼내온 동전 : " + coin.getValue() + "원");
        }
    }

    public void QueueExample() {
        // Queue 컬렉션 생성
        Queue<Message> messageQueue = new LinkedList<>();

        // 메세지 넣기
        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "신용권"));
        messageQueue.offer(new Message("sendKakaotalk", "감자바"));

        // 메세지를 하나씩 꺼내며 처리
        while (!messageQueue.isEmpty()) { // 비어있지 않다면 반복
            Message message = messageQueue.poll();
            switch (message.command) {
                case "sendMail":
                    System.out.println(message.to + "님에게 메일을 보냅니다.");
                    break;
                case "sendSMS":
                    System.out.println(message.to + "님에게 베일을 보냅니다.");
                    break;
                case "sendKakaotalk":
                    System.out.println(message.to + "님에게 카카오톡을 보냅니다.");
                    break;
            }
        }

    }

    public void SynchronizedMapExample() {
        // Map 컬렉션 생성
        Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());

        // 작업 스레드 객체 생성
        Thread threadA = new Thread() {
            @Override
            public void run() {
                // 객체 1000개 추가
                for(int i = 1; i <= 1000; i++) {
                    map.put(i, "내용"+i);
                }
            }
        };

        // 작업 스레드 객체 생성
        Thread threadB = new Thread() {
            @Override
            public void run() {
                for(int i = 1001; i <= 2000; i++) {
                    map.put(i, "내용"+i);
                }
            }
        };

        // 작업 스레드 실행
        threadA.start();
        threadB.start();

        // 작업 스레드들이 모두 종료될 때까지 메인 스레드를 기다리게 함
        try {
            threadA.join();
            threadB.join();
        } catch (Exception e) {
        }

        // 저장된 총 객체 수 얻기
        int size = map.size();
        System.out.println("총 객체 수: " + size);
        System.out.println();
    }

    public void ImmutableExample(){
        // List 불변 컬렉션 생성
        List<String> immutableList1 = List.of("A", "B", "C");
        //immutableList1.add("D"); (x)

        // Set 불변 컬렉션 생성
        Set<String> immutableSet1 = Set.of("A", "B", "C");
        // immutableSet1.remove("A"); (x)

        // Map 불변 컬렉션 생성
        Map<Integer, String> immutableMap1 = Map.of(
                1, "A",
                2, "B",
                3, "C"
        );
        // immutableMap1.put(4, "D"); (x)

        // List 컬렉션을 불변 컬렉션으로 복사
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        List<String> immutableList2 = List.copyOf(list);

        // Set 컬렉션을 불변 컬렉션으로 복사
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        Set<String> immutableSet2 = Set.copyOf(set);

        // Map 컬렉션을 불변 컬렉션으로 복사
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        Map<Integer, String> immutableMap2 = Map.copyOf(map);

        // 배열로부터 List 불변 컬렉션 생성
        String[] arr = {"A", "B", "C" };
        List<String> immutableList3 = Arrays.asList(arr);
    }
}

