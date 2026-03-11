package com.mjc813.server;

import com.mjc813.user.ChatUser;

import java.io.*;
import java.util.Set;

public class ServerChatSocket extends Thread {
	private final ChatUser chatUser;  // 비기본생성자로 객체를 받아들인다.
	private BufferedReader br;
	private BufferedWriter bw;
	private ServerChatInterface sci;
	private Set<ChatUser> users;

	public ServerChatSocket(ChatUser cu, ServerChatInterface sci) throws IOException {
		this.chatUser = cu;
		this.br = new BufferedReader(new InputStreamReader(cu.getSocket().getInputStream()));
		this.bw = new BufferedWriter(new OutputStreamWriter(cu.getSocket().getOutputStream()));
		this.sci = sci;
	}

	public ServerChatSocket(ChatUser cu, Set<ChatUser> users) throws IOException {
		this.chatUser = cu;
		this.br = new BufferedReader(new InputStreamReader(cu.getSocket().getInputStream()));
		this.bw = new BufferedWriter(new OutputStreamWriter(cu.getSocket().getOutputStream()));
		this.users = users;
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
			this.chatUser.getSocket().close();
		} catch (Exception ex) {
		}
	}

	@Override
	public void run() {
		BufferedReader br = null;
		try {
			while(true) {
				if ( this.chatUser == null
						|| this.br == null
						|| this.bw == null
						|| this.chatUser.getSocket() == null
						|| this.chatUser.getSocket().isClosed() ) {
					break;
					// 객체 멤버변수의 값이 비 정상이면 while 을 빠져나가서 스레드 종료
				}
				// ChatUser 의 소켓 입력 데이터를 String 으로 화면에 출력한다.
				String msg = this.br.readLine();
				System.out.printf(String.format("%s : %s\n", this.chatUser.getName(), msg));
			}
		} catch (IOException e) {
			System.out.println(this.chatUser.getName() + " 클라이언트 접속을 끊었습니다.");
		} finally {
			this.close();
//			this.sci.removeChatUser(this.chatUser);
			this.users.remove(this.chatUser);
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
}
