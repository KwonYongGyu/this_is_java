package com.mjc813.gugudan;

import java.awt.*;
import java.net.Socket;

public class TwoToFourGuGuDan extends Thread {
    private Socket socket;

    @Override
    public void run(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        for (int i = 2; i <= 4; i++) {
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
