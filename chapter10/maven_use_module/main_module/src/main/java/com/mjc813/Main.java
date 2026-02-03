package com.mjc813;

import com.mjc813_2.TransJson2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student stu = new Student("이순신", "mjc9283819", Major.InfoTelecom);
        TransJson tj = new TransJson();

        String strJson = tj.toJsonStringFromObject(stu);
        System.out.println(strJson);

        Object res = tj.toObjectFromJsonString(strJson, Student.class);
        if ( res instanceof Student stu2 ) {
            System.out.println(stu2);
        }
        System.out.println(tj.hashCode());
        System.out.println(res.hashCode());
        TransJson2 tr2 = new TransJson2(); // 외부에서 사용
    }
}