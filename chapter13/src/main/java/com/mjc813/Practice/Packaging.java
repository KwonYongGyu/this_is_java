package com.mjc813.practice;

import lombok.Data;

@Data
public class Packaging {
    private Object[] list = new Object[10];
    private int index = -1;

    public void add(Object obj) {
        if( index >= this.list.length - 1) {
            return;
        }
        this.list[++index] = obj;
    }

    public Object remove() {
        if( index < 0 ) {
            return null;
        }
        return this.list[index--];
    }
}
