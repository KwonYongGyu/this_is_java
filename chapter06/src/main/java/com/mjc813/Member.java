package com.mjc813;

public class Member {
    String name;
    String id;
    String password;
    int age;

    Member(String name, String id){
        this.name = name;
        this.id = id;
    }
    Member(String name, String id, String password, int age){
        this.name = name;
        this.id = id;
        this.password = password;
        this.age = age;
    }

    public void displayMember(){
        System.out.println("name: " + name +  "\t" + "id: " + id);
    }
}
