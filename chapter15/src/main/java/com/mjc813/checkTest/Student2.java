package com.mjc813.checkTest;

public class Student2 implements Comparable<Student2> {
    public String id;
    public int score;

    public Student2 (String id, int score) {
        this.id = id;
        this.score = score;

    }
    // 여기에 코드를 작성하세요
    @Override
    public int compareTo(Student2 o) {
        // 현재 객체의 점수가 매개값으로 들어온 객체의 점수보다 낮으면 음수.
        // 같으면 0, 높으면 양수를 리턴합니다.
        if(score < o.score) {
            return -1;
        } else if(score == o.score) {
            return 0;
        } else {
            return 1;
        }

        // 간단하게 작성할 경우: return Integer.compare(this.score, o.score);
    }
}
