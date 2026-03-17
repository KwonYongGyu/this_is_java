package com.mjc813.multiclientfreechat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp extends Thread {
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;

	public ClientApp() throws IOException {
		this.socket = new Socket(); // 클라이언트의 통신용 소켓 생성
	}

	public void connect() throws IOException {
//		this.socket.bind(new InetSocketAddress("localhost", 59998)); // ip 와 포트 정보를 bind 하고 접속 시도한다.
		this.socket.connect(new InetSocketAddress("10.11.83.61", 59997));
		// 해당 ip 와 포트로 접속을 시도한다.

		this.dis = new DataInputStream(new BufferedInputStream(this.socket.getInputStream()));
		this.dos = new DataOutputStream(new BufferedOutputStream(this.socket.getOutputStream()));
	}

	public void close() throws IOException {
		try {
			this.dos.close();
		} catch (Exception ex) {
		}
		try {
			this.dis.close();
		} catch (Exception ex) {
		}
		try {
			this.socket.close();
		} catch (Exception ex) {
		}
		// 클라이언트 통신 소켓을 닫는다.
	}

	public String read() throws IOException {
		String str = null;
//		try {
			str = this.dis.readUTF();
//		} catch (IOException e) {
//			System.err.println("데이터 입력 받을 수 없습니다.");
//			System.exit(-82429);
//		}
		return str;
	}

	@Override
	public void run() {
		// 서버로부터 데이터를 읽는 동작을 해야 한다.
		// 읽어서 화면에 출력해야 한다.
		// 왜 스레드에서 실행해야 하나요 ? 읽는 동작이 블로킹모드가 되기 때문이다.
		String msg = null;
		try {
			while( true ) {
				msg = this.read();
				System.out.println("From Server : " + msg);
			}
		} catch (IOException e) {
			System.out.println("접속이 끊겼습니다.");
			System.exit(-345);
		}
	}


	public void send(String msg) {
		try {
			this.dos.writeUTF(msg);
			this.dos.flush();
		} catch (Exception ex) {
			System.out.println("접속이 끊겼습니다.");
			System.exit(-345);
		}
	}

	public static void main(String[] args) {
		Scanner scanner;
		ClientApp ca = null;
		try {
			scanner = new Scanner(System.in);
			ca = new ClientApp();
			ca.connect();
			ca.start();

			while(true) {
				String str = scanner.nextLine();
				ca.send(str);
			}
		} catch (Exception ex) {
			System.err.println(ex.toString());
		} finally {
			try {
				ca.close();
			} catch (Exception ex) {
			}
		}
	}
}
