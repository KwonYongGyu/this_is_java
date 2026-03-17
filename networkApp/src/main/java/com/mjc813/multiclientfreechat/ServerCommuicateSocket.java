package com.mjc813.multiclientfreechat;

import java.io.*;
import java.net.Socket;

public class ServerCommuicateSocket extends Thread {
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	private ServerNetworkInterface sni;

	public  ServerCommuicateSocket(Socket socket, ServerNetworkInterface sni) throws IOException {
		this.socket = socket;
		this.dis = new DataInputStream(new BufferedInputStream(this.socket.getInputStream()));
		this.dos = new DataOutputStream(new BufferedOutputStream(this.socket.getOutputStream()));
		this.sni = sni;
	}

	public void send(String msg) throws IOException {
		// this.dos 를 이용하여 msg 를 전송하는 코딩 하세요
		this.dos.writeUTF(msg);
		this.dos.flush();
	}

	public String read() throws IOException {
		// this.dis 를 이용하여 InputStream 문자를 읽어서 str 에 리턴하는 코딩 하세요.
		// 읽는 동작은 블로킹모드 이므로 스레드에서 실행하도록 해야 한다.
		String str = this.dis.readUTF();
		return str;
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

	@Override
	public void run() {
		try {
			while (true) {
				String msg = this.read();
//				System.out.println("From Client : " + msg );
				this.sni.sendAllClients(msg);
			}
		} catch (Exception e) {
			System.out.println("Client 접속 끊김");
		}
		this.close();
		this.sni.deleteClient(this);
	}
}
