package com.mjc813;


import java.net.InetAddress;
import java.net.UnknownHostException;

import java.io.IOException;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetSocketAddress;

public class Chapter19 {
    public void inetAddressExample() {
        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("내 컴퓨터 IP 주소: " + local.getAddress());

            InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
            for(InetAddress remote : iaArr) {
                System.out.println("www.naver.com IP 주소: " + remote.getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


//
//    public void ClientExample() {
//        try {
//            // Socket 생성과 동시에 localhost의 50001 Port로 연결 요청;
//            Socket socket = new Socket("localhost", 50001);
//
//            System.out.println("[클라이언트] 연결 성공");
//
//            // Socket 닫기
//            socket.close();
//            System.out.println("[클라이언트] 연결 끊음");
//        } catch (java.net.UnknownHostException e) {
//            // IP 표기 방법이 잘못되었을 경우
//            } catch (IOException e) {
//            // 해당 포트의 서버에 연결할 수 없는 경우
//        }
//    }
}
