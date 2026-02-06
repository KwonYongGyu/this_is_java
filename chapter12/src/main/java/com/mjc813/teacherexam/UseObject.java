package com.mjc813.teacherexam;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UseObject {

    private String id;
    private String name;



    @Override
    public boolean equals(Object ob) {

        // this 와 매개변수 obj를 빅해서 같을때 true
        if (ob instanceof UseObject object  // 매개변수 ob 가 UseObject 클래스형 이니 체크
            &&this.hashCode() == ob.hashCode()    // 자기의 주소의 매개변수 ob 객체의 주소가
            && this.getId().equals(object.getId())
            && this.getName().equals(object.getName())) {
                return true;
        }
        return false;
    }

//    @Override
//    public int hashCode(){
//        int num =  super.hashCode();
//        return num;
//    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Object 의 clone 메소드를 오버라이드 할때는 객체 복사를 깊은 복사를 시킬려고 한다.
        // 멤버변수들의 값을 이용하여 새로운 객체를 만들어서 리턴하는 형태로 자주 사용된다.
        return new UseObject(this.getId(), this.getName());
    }


}

