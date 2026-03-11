package com.mjc813;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = -6218128684700778544L;
    private String id;
    private int price;

    public Product(String id, int price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + ": " + price;
    }
}
