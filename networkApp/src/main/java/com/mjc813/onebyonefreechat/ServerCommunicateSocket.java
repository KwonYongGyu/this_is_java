package com.mjc813.onebyonefreechat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerCommunicateSocket {
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;

	public ServerCommunicateSocket(Socket socket) {
		this.socket = socket;
        try {
            this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
        }

//		this.dis = new ~~~~;    코딩하세요
//		this.dos = new ~~~~;    코딩하세요
	}

	public void send(String msg) {
		// this.dos 를 이용하여 msg 를 전송하는 코딩 하세요
        try {
            dos.writeUTF(msg);
			dos.flush();
        } catch (IOException e) {
        }
    }

	public String read() {
		String str = "";
		// this.dis 를 이용하여 InputStream 문자를 읽어서 str 에 리턴하는 코딩 하세요.
		// 읽는 동작은 블로킹모드 이므로 스레드에서 실행하도록 해야 한다.
        try {
            str = dis.readUTF();
        } catch (IOException e) {
			return null;
        }

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
}
