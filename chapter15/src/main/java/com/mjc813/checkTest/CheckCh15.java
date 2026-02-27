package com.mjc813.checkTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CheckCh15 {
    public void Number7() {
        BoardDao dao = new BoardDao();
        List<Board> list = dao.getBoardlist();
        for(Board board : list) {
            System.out.println(board.getTitle() + "-" board,getContent());
        }
    }

    public void Number8(){
        Set<Student> set = new HashSet<Student>();

        set.add(new Student(1, "홍길동"));
        set.add(new Student(2, "신용권"));
        set.add(new Student(3, "조민우"));

        System.out.println("저자오딘 객체 수: " +set.size());
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
    }
}
