package com.mjc813.client;

import com.mjc813.server.ServerMain;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain2 extends Thread {
	// ChatUser 는 서버 접속후에 닉네임을 전송해야 한다.
	// InputStream 이 블록킹상태므로 스레드가 필요하다.
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;

	public ClientMain2(String ip) {
		try {
			this.socket = new Socket(ip, ServerMain.port);
			this.br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.bw = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void close() {
		try {
			this.bw.close();
		} catch (Exception ex) {
		}
		try {
			this.br.close();
		} catch (Exception ex) {
		}
		try {
			this.socket.close();
		} catch (Exception ex) {
		}
	}

	public void send(String msg) {
		try {
			this.bw.write(msg);
			this.bw.newLine();
			this.bw.flush();
		} catch (Exception ex) {
			this.close();
		}
	}

	public void doChat() {
		Scanner scanner = new Scanner(System.in);
		try {
			while( true ) {
				String msg = scanner.nextLine();
				if ( msg.equals("quit") ) {
					break;
				}
				this.send(msg);
			}
		} catch (Exception ex) {
			System.out.println("서버 접속이 끊겼습니다.");
		} finally {
			try {
				bw.close();
			} catch (Exception e) {
			}
			try {
				scanner.close();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public void run() {
		try {
			while(true) {
				String msg = this.br.readLine();
				System.out.println("Server:" + msg);
			}
		} catch (Exception ex) {
			System.out.println("접속이 끊겼습니다.");
		} finally {
			this.close();
			System.exit(-999);
		}
	}

	public static void main(String[] args) {
		if ( args.length != 1 ) {
			System.out.println("서버 IP 를 인자로 넣어주세요.");
			return;
		}
		try {
			ClientMain2 cm = new ClientMain2(args[0]);
			cm.start();
			cm.doChat();
		} catch (Throwable ex) {
			System.out.println(ex.toString());
		}
	}
}
