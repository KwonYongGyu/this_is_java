package com.mjc813.gugudan;

import java.awt.Toolkit;

public class GuGuDanExample {
    public static void main(String[] args) {
//        Toolkit toolkit = Toolkit.getDefaultToolkit();

        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
            }

        }
    }
}

