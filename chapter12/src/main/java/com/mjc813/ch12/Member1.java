package com.mjc813.ch12;

public class Member1 {
    public String id;

    public Member1(String id){
        this.id = id;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Member1 target){
            if(id.equals(target.id)){
                return true;
            }
        }
        return false;
    }
}
