package com.mjc813.checkTest;

import java.util.*;

public class CheckCh15 {
    public void Number7() {
        BoardDao dao = new BoardDao();
        List<Board> list = dao.getBoardlist();
        for(Board board : list) {
            System.out.println(board.getTitle() + "-" + board.getContent());
        }
    }

    public void Number8(){
        Set<Student> set = new HashSet<>();

        set.add(new Student(1, "홍길동"));
        set.add(new Student(2, "신용권"));
        set.add(new Student(1, "조민우"));

        System.out.println("저장된 객체 수: " +set.size());
        for(Student s : set) {
            System.out.println(s.studentNum + ":" + s.name);
        }
    }

    public void Number9(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("blue", 96);
        map.put("hong", 86);
        map.put("white", 92);

        String name = null; // 최고 점수를 받은 아이디를 저장하는 변수
        int maxScore = 0;   // 최고 점수를 저장하는 변수
        int totalScore = 0; // 점수 합계를 저장하는 변수

        //여기에 코드를 입력하세요.
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String id = entry.getKey();
            int score = entry.getValue();

            // 1. 점수 합계 누적
            totalScore += score;

            // 2. 최고 점수 및 해당 아이디 찾기
            if(score > maxScore) {
                maxScore = score;
                name = id;
            }
        }

        // 3. 평균 머수 계산(정수형 결과 91을 위해 나누기 연산)
        int avgScore = totalScore / map.size();

        System.out.println("평균 점수 : " + avgScore);
        System.out.println("최고 점수 : " + maxScore);
        System.out.println("최고 점수를 받은 아이디 : " + name);
    }

    public void Number10(){
        TreeSet<Student2> treeSet = new TreeSet<Student2>();
        treeSet.add(new Student2("blue", 96));
        treeSet.add(new Student2("hong",86));
        treeSet.add(new Student2("white", 92));

        Student2 student2 = treeSet.last();
        System.out.println("최고 점수: " + student2.score);
        System.out.println("최고 점수를 받은 아이디: " + student2.id);
    }
}
