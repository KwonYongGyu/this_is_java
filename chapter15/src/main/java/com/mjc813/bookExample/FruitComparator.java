package com.mjc813.bookExample;

import java.util.Comparator;
import java.util.function.Function;

public class FruitComparator implements Comparator<Fruit> {
    @Override
    public int compare(Fruit o1, Fruit o2) {
        if(o1.price < o2.price) return -1;
        else if(o1.price == o2.price) return 0;
        else return 1;
    }

}
