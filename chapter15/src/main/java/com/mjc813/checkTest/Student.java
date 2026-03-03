package com.mjc813.checkTest;

public class Student {
    public int studentNum;
    public String name;

    public Student (int studentNum, String name) {
        this.studentNum = studentNum;
        this.name = name;
    }

    // 여기에 코드를 작성하세요
    // 1. hashCode 오버라이딩 : 학번을 해시코드로 변환
    @Override
    public int hashCode() {
        return studentNum;
    }

    // 2. equals 오버라이딩 : 학번이 같으면 true 반환
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student) {
            Student student = (Student) obj;
            return student.studentNum == this.studentNum;
        }
        return false;
    }
}
