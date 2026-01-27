package com.mjc813;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor // 모든 필드를 매개값으로 받는 생성자 생성
public class GetGrade {
    private String studentName; // 학생이름
    private String studentId;   // 학번
    private String lecture; // 강의 과목
    private int score;  // 성적
    public void grade(int score, int grade){

        if (score >= 90) {
            grade = 'A';
        }
        else if (score >= 80){
            grade = 'B';
        }
        else if (score >= 70){
            grade = 'C';
            }
        else if (score >= 60) {
            grade = 'D';
            }
        else{
            grade = 'F';
            }

        System.out.println("등급: " + grade);

    }
}
