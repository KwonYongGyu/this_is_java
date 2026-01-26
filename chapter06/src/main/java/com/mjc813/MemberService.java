package com.mjc813;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

import com.mjc813.Member;
public class MemberService {
    String id;
    String password;


    public boolean login(String id, String password){
        if(id == "hong" && password =="12345"){
            return true;
        }
        else{
            return false;
        }

    }
    public void logout(String id){
        System.out.println(id + "님이 로그아웃 되었습니다.");
    }

//    MemberService(String id, String password) {
//        this.id = id;
//        this.password = password;
//    }
//
//
//    public void logout() {
//        System.out.println(id + "님이 로그아웃 되었습니다.");
//    }
//
//    public boolean login(String hong, String number) {
//    }
}
