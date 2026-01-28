package com.mjc813;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person{
    // 필드 선언
    private int studentNo;

    // 생성자 선언
    public Student(String name, int studentNo){
        super(name);    // 부모 생성자 호출
        this.studentNo = studentNo;
    }

    // 메소드 선언
    public void study(){
        System.out.println("공부를 합니다.");
    }
}
