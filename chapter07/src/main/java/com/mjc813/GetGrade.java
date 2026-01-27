package com.mjc813;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetGrade {
    private String studentName; // 학생이름
    private String studentId;   // 학번
    private String lecture;     // 강의 과목
    private int score;          // 성적

    // 성적 점수를 기반으로 등급(A~F)을 반환하는 메서드
    public String getGradeLevel() {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }

    @Override
    public String toString() {
        return String.format("이름: %s | 학번: %s | 과목: %s | 점수: %d | 등급: %s",
                studentName, studentId, lecture, score, getGradeLevel());
    }
}