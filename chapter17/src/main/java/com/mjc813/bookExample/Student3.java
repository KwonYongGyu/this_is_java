package com.mjc813.bookExample;

public class Student3 implements Comparable<Student3> {
    private String name;
    private int score;

    public Student3(String name, int score) {
         this.name = name;
         this.score = score;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student3 o) {
        return Integer.compare(score, o.score);
    }
}
