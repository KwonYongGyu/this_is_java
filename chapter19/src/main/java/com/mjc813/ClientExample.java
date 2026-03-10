package com.mjc813;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientExample {
    public static void main(String [] args) throws IOException {
        Socket socket = null;
        Scanner scanner = null;
        try {
            // Socket 생성과 동시에 localhost의 50001 Port로 연결 요청;
            // 내 IP 10.11.83.68
            // 충섭씨 IP 10.11.83.69
             socket = new Socket("10.11.83.69", 50001);

            System.out.println( "[클라이언트] 연결 성공");

             scanner = new Scanner(System.in);
            String msg = scanner.nextLine();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(msg);


        } catch (UnknownHostException e) {
            // IP 표기 방법이 잘못되었을 경우
            System.out.println("IP 표기 방법이 잘못되었습니다.");
        } catch (IOException e) {
            // 해당 포트의 서버에 연결할 수 없는 경우
            System.out.println("해당 포트의 서버에 연결할 수 없습니다.");
        } finally {
            // Socket 닫기
            socket.close();
            System.out.println("[클라이언트] 연결 끊음");
            scanner.close();
        }
    }
}
