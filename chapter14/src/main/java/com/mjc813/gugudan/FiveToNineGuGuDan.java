package com.mjc813.gugudan;

import java.awt.*;

public class FiveToNineGuGuDan extends Thread {

    @Override
    public void run(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        for (int i = 5; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                }
            }

        }
    }
}
