package com.mjc813.basic;

// 서버소캣 생성(ip대역 option, 포트번호 필수)
// 클라이언트 접속 기다리는 동작(블로킹)
// 클라이언트 접속이 되면 새로운 데이터 소캣/클라이언트 통신 소캣을 리턴한다.
// 새로운 통신 소캣과 클라이언트가 통신하도록 프로그래밍 해야 한다.
// 종료시에는 소캣과 자원을 모조리 해제 해야 하낟.

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerApp {
    private ServerSocket serverSocket;
    private DataInputStream dis;
    private DataOutputStream dos;


    public ServerApp() throws IOException {
        this.serverSocket = new ServerSocket(59999);
        // 포트번호로 서비소캣을 생성한다.
    }

    public Socket accept() throws IOException {
        return this.serverSocket.accept();
        // 생성된 소캣으로 서버는 클라이언트 연결을 기다린다.
        // 클라이언트 연결이 되면 Socket 객체를 리턴한다.
    }

    public void close() throws IOException {
        this.serverSocket.close();
    }

    public static void main(String [] args) {
        try {
            ServerApp sa = new ServerApp();
            Socket clientsocket = sa.accept();
            // 클라이언트가 연결되면 socket (새로운 클라이언트통신 소캣) 으로 통신이 가능하다.

            // 서버가 클라이언트에게 데이터를 전송한다.
            String str = "Welcome server";
            DataOutputStream dos = new DataOutputStream(clientsocket.getOutputStream());
            dos.writeUTF(str);
            dos.flush();
//            clientsocket.getOutputStream().write(str.getBytes(StandardCharsets.UTF_8));
//            clientsocket.getOutputStream().flush();

            // 클라이언트 통신 소캣으로부터 데이터를 읽어서 출력한다.
//            byte[] buf = new byte[1024];
            BufferedReader br = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
            String msg = br.readLine();
            System.out.println(msg);

            // 통신 소캣을 닫음
            clientsocket.close();

            // 서버 소캣을 닫음
            sa.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }


    }
}
