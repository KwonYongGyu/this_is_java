package com.mjc813.onebyonefreechat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerCommuicateSocket extends Thread {
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;

	public  ServerCommuicateSocket(Socket socket) throws IOException {
		this.socket = socket;
//		this.dis = new ~~~~;    코딩하세요
		this.dis = new DataInputStream(socket.getInputStream());
//		this.dos = new ~~~~;    코딩하세요
		this.dos = new DataOutputStream(socket.getOutputStream());
	}

	public void send(String msg) {
		// this.dos 를 이용하여 msg 를 전송하는 코딩 하세요
        try {
            dos.writeUTF(msg);
			dos.flush();
        } catch (IOException e) {
            System.out.println("전송 실패 : " + e.getMessage());
        }

	}

//	public String read() {
//		String str = "";
//		// this.dis 를 이용하여 InputStream 문자를 읽어서 str 에 리턴하는 코딩 하세요.
//		// 읽는 동작은 블로킹모드 이므로 스레드에서 실행하도록 해야 한다.
//		return str;
//	}

	@Override
	public void run() {
		try {
			while (true) {
				String msg = dis.readUTF();
				System.out.println("\n[CLIENT]: " + msg);
				System.out.print("나(SERVER): "); // 입력 UI 가이드
			}
		} catch (IOException e) {
			System.out.println("클라이언트와 연결이 끊어짐");
		} finally {
			close();
		}
	}

	public void close() {
		try {
			this.dos.close();
		} catch (Exception e) {
		}
		try {
			this.dis.close();
		} catch (Exception e) {
		}
		try {
			this.socket.close();
		} catch (Exception e) {
		}
	}
}
